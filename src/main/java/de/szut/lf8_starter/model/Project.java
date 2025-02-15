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
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private long Id;

    @Column(name = "project_bezeichnung")
    private String Bezeichnung;

    @Column(name = "project_ver_ma_id")
    private int VerMAid;

    @Column(name = "zu_ma")
    private String zuMAname;

    @Column(name = "project_kunden_id")
    private int KundenId;

    @Column(name = "project_kommentar")
    private String Kommentar;

    @Column(name = "project_start_datum")
    private Date Startdatum;

    @Column(name = "project_geplantes_enddatum")
    private Date geplantesEnddatum;

    @Column(name = "project_tatsaechliches_enddatum")
    private Date tatsaechlichesEnddatum;

    @ElementCollection
    private List<Long> employee_id;

    @Override
    public String toString() {
        return "Project{" +
                "Id=" + Id +
                ", Bezeichnung='" + Bezeichnung + '\'' +
                ", VerMAid=" + VerMAid +
                ", zuMAname='" + zuMAname + '\'' +
                ", KundenId=" + KundenId +
                ", Kommentar='" + Kommentar + '\'' +
                ", Startdatum=" + Startdatum +
                ", geplantesEnddatum=" + geplantesEnddatum +
                ", tatsaechlichesEnddatum=" + tatsaechlichesEnddatum +
                ", employee_id=" + employee_id +
                '}';
    }

}
