import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OracleCertificateList {

	public static void main(String[] args) {
		try {
			File file = new File("/Users/sucherrywine/Documents/UnionTec/employee.txt");
			FileReader fr = new FileReader(file);
			HashMap<String, String> empMap = new HashMap<String, String>();
			StringBuilder sb = new StringBuilder();
			int employee;
			while ((employee = fr.read()) != -1) {
				sb.append((char) employee);
			}
			fr.close();

			String[] strArray = sb.toString().split("\n");
			for (int i = 0; i < strArray.length; i++) {
				if (i == 0) {
					continue;
				}

				String[] emp = strArray[i].split(",");
				empMap.put(emp[0], emp[1]);
			}

			File listFile = new File("/Users/sucherrywine/Documents/UnionTec/oracle_bronze_certificate_list.txt");
			FileReader r = new FileReader(listFile);
			HashMap<String, String> certificateMap = new HashMap<String, String>();
			StringBuilder sbCertificate = new StringBuilder();
			int oracleCertificate;
			while ((oracleCertificate = r.read()) != -1) {
				sbCertificate.append((char) oracleCertificate);
			}
			r.close();

			String[] certificateArr = sbCertificate.toString().split("\n");
			for (int j = 0; j < certificateArr.length; j++) {
				if (j == 0) {
					continue;
				}
				String[] certificate = certificateArr[j].split(",");
				certificateMap.put(certificate[1], certificate[0]);
			}

			StringBuilder sbFinal = new StringBuilder();
			sbFinal.append("資格取得日,社員番号,社員名\n");

			for (Map.Entry<String, String> certificateEntry : certificateMap.entrySet()) {
				String code = certificateEntry.getKey();
				String date = certificateEntry.getValue();
				String name = empMap.get(code.trim());
				sbFinal.append(date.trim() + "," + code.trim() + "," + name.trim() + "\n");
			}

			PrintWriter pw = new PrintWriter(
					new File("/Users/sucherrywine/Documents/UnionTec/oracle_bronze_certificate_list_name.txt"));
			pw.write(sbFinal.toString());
			pw.close();
			pw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
