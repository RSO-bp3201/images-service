package fileuploader;

import com.cloudinary.Cloudinary;
import com.cloudinary.Transformation;
import com.cloudinary.utils.ObjectUtils;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class FileUploader {
    private final Cloudinary cloudinary;
    public FileUploader(){
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dwon7bysc",
                "api_key", "283841692368561",
                "api_secret", "RpZtPsloGfauKDeeqoSkEjkBRmk"));
    }

    public Map<String, String> uploadImage(InputStream uploadedInputStream) throws IOException {
        Map uploadResult = this.cloudinary.uploader().upload(uploadedInputStream, ObjectUtils.emptyMap());
        String imageUri = uploadResult.get("uri").toString();
        String cloudinaryId = uploadResult.get("public_id").toString();
        Map<String, String> uploadData = new HashMap<>();
        uploadData.put("uri", imageUri);
        uploadData.put("public_id", cloudinaryId);

        return uploadData;
    }


}
