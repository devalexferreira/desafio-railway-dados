package dev.alex.api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_user")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String document;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Phone> phones;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Family> family;

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Family> getFamily() {
        return family;
    }

    public void setFamily(List<Family> family) {
        this.family = family;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
