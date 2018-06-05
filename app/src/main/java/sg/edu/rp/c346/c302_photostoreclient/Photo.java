package sg.edu.rp.c346.c302_photostoreclient;

public class Photo {
    private String title,description ,image, created_by;

    public Photo(String title, String description, String image, String created_by) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.created_by = created_by;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }
}
