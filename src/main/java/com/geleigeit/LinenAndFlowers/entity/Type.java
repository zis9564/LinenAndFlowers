package com.geleigeit.LinenAndFlowers.entity;

import javax.persistence.*;

@Entity
@Table(name = "types")
public class Type {

    private long id;
    private String type;
//    private Set<Fabric> fabrics = new HashSet<>();

    public Type() {
    }

    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "type", unique = true)
    public String getType() {
        return type;
    }

//    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    public Set<Fabric> getFabrics() { return fabrics;
//    }

    public void setId(long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public void setFabrics(Set<Fabric> fabrics) {
//        this.fabrics = fabrics;
//    }

//    @Override
//    public String toString() {
//        return "id=" + id + ", fabrics=" + fabrics;
//    }
}
