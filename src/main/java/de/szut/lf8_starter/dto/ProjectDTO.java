package de.szut.lf8_starter.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private long Id;

    private String Bezeichnung;

    private int VerMAid;

    private String zuMAname;

    private int KundenId;

    private String Kommentar;

    private Date Startdatum;

    private Date geplantesEnddatum;

    private Date tatsaechlichesEnddatum;

    private List<Long> employeeId;
}
