public class Album {
    String name;
    int publicationYear;
    int rating;

    public Album(String name, int publicationYear, int rating) {
        this.name = name;
        this.publicationYear = publicationYear;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public float getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
