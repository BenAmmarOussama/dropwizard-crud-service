package org.eniso.pmfwk.old;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(schema = "public", name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "content")
    private String content;

    public Message() {
    }

    public Message( String content) {
        this.content = content;
    }

    @JsonProperty
    public int getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
