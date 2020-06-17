package datalayer.dto;

public class TodoDTO {

    private int id;

    private String text;

    private String datum;

    private int urgency;

    public TodoDTO(int id, String text,String datum, int urgency) {
        this.id = id;
        this.text = text;
        this.datum = datum;
        this.urgency = urgency;
    }
}
