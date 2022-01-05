package rsatu.course.resource;

import org.jboss.resteasy.reactive.MultipartForm;
import rsatu.course.multipart.MultipartBody;
import rsatu.course.pojo.FileInfo;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

@Path("api/file")
public class FileResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("/upload")
    @Transactional
    public Response uploadFile(@MultipartForm MultipartBody data) {
        if (data != null && data.file != null && data.idCompetition != null && data.originalName != null) {
            try {
                String resourceDirectory = Paths.get("src", "main", "resources", "uploadReports").toFile()
                        .getAbsolutePath();
                String pathToFile = resourceDirectory + "/" + data.idCompetition + data.originalName;
                OutputStream os = new FileOutputStream(pathToFile);
                Files.copy(data.file.toPath(), os);
                FileInfo fileInfo = new FileInfo();
                fileInfo.name = data.idCompetition + data.originalName;
                fileInfo.uploadDate = LocalDate.now();
                fileInfo.idCompetition = data.idCompetition;
                fileInfo.persist();
                return Response.ok(fileInfo).build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Response.serverError().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Path("/download")
    public Response downloadFileByIdComp(Long id) {
        FileInfo info = FileInfo.findFileInfoByIdComp(id);
        if (info != null) {
            String resourceDirectory = Paths.get("src", "main", "resources", "uploadReports").toFile()
                    .getAbsolutePath();
            String pathToFile = resourceDirectory + "/" + info.name;
            File fileDownload = new File(pathToFile);
            if (fileDownload.exists()) {
                Response.ResponseBuilder response = Response.ok((Object) fileDownload);
                response.header("Content-Disposition", "attachment;filename=" + info.name);
                return response.build();
            }
        }
        return Response.serverError().build();
    }
}
