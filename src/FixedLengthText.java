import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FixedLengthText {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("/Users/sucherrywine/Documents/UnionTec/file_layout.txt");
			Scanner sc = new Scanner(fis);
			String[] nums = {};
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				nums = line.split(",");
			}
			sc.close();
			File file = new File("/Users/sucherrywine/Documents/UnionTec/労働者名簿_固定長.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				int beginIndex = 0;
				for (int i = 0; i < nums.length; i++) {
					int endIndex = beginIndex + Integer.parseInt(nums[i]);
					sb.append(line.substring(beginIndex, endIndex));
					if (nums.length > i + 1) {
						sb.append(",");
					}
					beginIndex = endIndex;
				}
				sb.append("\n");
			}
			fr.close();
			PrintWriter writer = new PrintWriter(new File("/Users/sucherrywine/Documents/UnionTec/労働者名簿_固定長_CSV.txt"));
			writer.write(sb.toString());
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
