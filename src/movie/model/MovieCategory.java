package movie.model;
//For movie category and can extends its functionality for validation and other porpuses
public enum MovieCategory {
    REGULAR("regular"),
    NEW("new"),
    CHILDREN("childrens");
    MovieCategory(String value){
        this.value = value;
    }
    String value;

    @Override
    public String toString() {
        return value;
    }
}
