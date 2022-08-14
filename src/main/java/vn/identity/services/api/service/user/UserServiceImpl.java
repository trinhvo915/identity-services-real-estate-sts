package vn.identity.services.api.service.user;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import vn.identity.services.api.entity.Diem;
import vn.identity.services.api.repository.DiemRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    DiemRepository diemRepository;

    @Override
    public void getByIdUser(String Id) {
        // TO DO
    }

    @Async
    @Override
    public void saveDiem() throws IOException {
        BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/diem_thi_thpt_2022.csv"));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                .withHeader("SBD", "Toan", "NguVan", "TiengAnh", "VatLi", "HoaHoc", "SinhHoc", "LichSu", "DiaLy", "GDCD")
                .withIgnoreHeaderCase().withTrim());

        for (CSVRecord csvRecord: csvParser) {
            String SBD = csvRecord.get(0);

            String ToanFile = csvRecord.get(1);
            Double Toan = null;
            if (ToanFile.isEmpty()){
                Toan = null;
            } else if(Objects.nonNull(ToanFile)){

                if (ToanFile.contains(".")) {
                    Integer afterDot = Integer.parseInt(ToanFile.substring(ToanFile.indexOf('.') + 1));

                    Integer beforeDot = Integer.parseInt(String.valueOf(ToanFile.charAt(0)));

                    switch (afterDot) {
                        case 2: {
                            Toan = Float.parseFloat(String.valueOf(beforeDot)) + 0.25;
                            break;
                        }
                        case 4, 6: {
                            Toan = Float.parseFloat(String.valueOf(beforeDot)) + 0.5;
                            break;
                        }
                        case 8: {
                            Toan = Float.parseFloat(String.valueOf(beforeDot)) + 0.75;
                            break;
                        }
                        default:
                            Toan = null;
                    }
                } else {
                    Toan = Double.parseDouble(ToanFile);
                }

            }
            else {
                if(ToanFile.isEmpty()){
                    Toan = null;
                }else {
                    Toan = Double.parseDouble(ToanFile);
                }
            }

            String TiengAnhFile = csvRecord.get(3);
            Double TiengAnh = null;
            if (TiengAnhFile.isEmpty()){
                TiengAnh = null;
            } else if (Objects.nonNull(TiengAnhFile)) {
                if (TiengAnhFile.contains(".")) {
                    Integer afterDot = Integer.parseInt(TiengAnhFile.substring(TiengAnhFile.indexOf('.') + 1));

                    Integer beforeDot = Integer.parseInt(String.valueOf(TiengAnhFile.charAt(0)));

                    switch (afterDot) {
                        case 2: {
                            TiengAnh = Float.parseFloat(String.valueOf(beforeDot)) + 0.25;
                            break;
                        }
                        case 4, 6: {
                            TiengAnh = Float.parseFloat(String.valueOf(beforeDot)) + 0.5;
                            break;
                        }
                        case 8: {
                            TiengAnh = Float.parseFloat(String.valueOf(beforeDot)) + 0.75;
                            break;
                        }
                        default:
                            TiengAnh = null;
                    }
                } else {
                    if(TiengAnhFile.isEmpty()){
                        TiengAnh = null;
                    }else {
                        TiengAnh = Double.parseDouble(TiengAnhFile);
                    }
                }

            } else {
                TiengAnh = null;
            }

            String NguVan = csvRecord.get(2);
            String VatLi = csvRecord.get(4);
            String HoaHoc = csvRecord.get(5);
            String SinhHoc = csvRecord.get(6);
            String LichSu = csvRecord.get(7);
            String DiaLy = csvRecord.get(8);
            String GDCD = csvRecord.get(9);

            Diem diem = Diem.builder()
                    .SBD(SBD)
                    .Toan(Objects.isNull(Toan) ? null : Float.parseFloat(String.valueOf(Toan)))
                    .NguVan(Objects.isNull(NguVan) || NguVan.isEmpty() ? null : Float.parseFloat(NguVan))
                    .TiengAnh(Objects.isNull(TiengAnh) ? null : Float.parseFloat(String.valueOf(TiengAnh)))
                    .VatLi(Objects.isNull(VatLi) || VatLi.isEmpty() ? null : Float.parseFloat(VatLi))
                    .HoaHoc(Objects.isNull(HoaHoc) || HoaHoc.isEmpty() ? null : Float.parseFloat(HoaHoc))
                    .SinhHoc(Objects.isNull(SinhHoc) || SinhHoc.isEmpty() ? null : Float.parseFloat(SinhHoc))
                    .LichSu(Objects.isNull(LichSu) || LichSu.isEmpty() ? null : Float.parseFloat(LichSu))
                    .DiaLy(Objects.isNull(DiaLy) || DiaLy.isEmpty() ? null : Float.parseFloat(DiaLy))
                    .GDCD(Objects.isNull(GDCD) || GDCD.isEmpty() ? null : Float.parseFloat(GDCD))
                    .build();

            diemRepository.save(diem);
        }
    }
}
