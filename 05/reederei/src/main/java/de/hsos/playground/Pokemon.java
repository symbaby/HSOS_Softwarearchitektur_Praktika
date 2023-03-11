package de.hsos.playground;

import javax.persistence.*;

@Entity
@Table(name = "pokemon_table")
@NamedQuery(name = "Pokemon.findAll", query = "SELECT p FROM Pokemon p ORDER BY  p.name", hints = @QueryHint(name = "org.hibernate.cacheable", value = "true"))
@Cacheable
public class Pokemon {

    @Id
    private Long id;

    private String name;

    @Embedded
    private EmbeddedTest embeddedTest;

    public Pokemon(Long id, String name) {
        this.id = id;
        this.name = name;
        this.embeddedTest = new EmbeddedTest();
    }

    public Pokemon() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public EmbeddedTest getEmbeddedTest() {
        return embeddedTest;
    }

    public void setEmbeddedTest(EmbeddedTest embeddedTest) {
        this.embeddedTest = embeddedTest;
    }
}
