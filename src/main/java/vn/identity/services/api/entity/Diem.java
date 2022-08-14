package vn.identity.services.api.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Diem")
public class Diem {

    @Id
    private String SBD;

    @Column(name = "Toan")
    private Float Toan;

    @Column(name = "NguVan")
    private Float NguVan;

    @Column(name = "TiengAnh")
    private Float TiengAnh;

    @Column(name = "VatLi")
    private Float VatLi;

    @Column(name = "HoaHoc")
    private Float HoaHoc;

    @Column(name = "SinhHoc")
    private Float SinhHoc;

    @Column(name = "LichSu")
    private Float LichSu;

    @Column(name = "DiaLy")
    private Float DiaLy;

    @Column(name = "GDCD")
    private Float GDCD;
}
