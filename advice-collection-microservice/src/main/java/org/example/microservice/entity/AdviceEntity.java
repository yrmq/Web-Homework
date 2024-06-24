package org.example.microservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "ADVICE")
public class AdviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String title;

    private String email;

    private String detail;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd_HH:mm:ss", timezone = "GMT+8")
    @CreatedDate
    private Date dateCreated;

    public AdviceEntity() {
    }

    public AdviceEntity(long id, String name, String title, String email, String detail, Date dateCreated) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.email = email;
        this.detail = detail;
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "AdviceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", detail='" + detail + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdviceEntity that = (AdviceEntity) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(title, that.title) && Objects.equals(email, that.email) && Objects.equals(detail, that.detail) && Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, title, email, detail, dateCreated);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
