package de.szut.lf8_starter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Projekte")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long Id;

    @Column(name = "project_bezeichnung")
    private String Bezeichnung;

    @Column(name = "project_verMAid")
    private int VerMAid;

    @Column(name = "zuMA")
    private String zuMAname;

    @Column(name = "project_kundenID")
    private int KundenId;

    @Column(name = "project_kommentar")
    private String Kommentar;

    @Column(name = "project_startDatum")
    private Date Startdatum;

    @Column(name = "project_geplantesEnddatum")
    private Date geplantesEnddatum;

    @Column(name = "project_tatsaechlichesEnddatum")
    private Date tatsaechlichesEnddatum;

    @ElementCollection
    private List<Long> employeeId;

}
