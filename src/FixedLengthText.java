import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FixedLengthText {

	public static void main(String[] args) {
		
		try {
			File file = new File("/Users/sucherrywine/Documents/UnionTec/労働者名簿_固定長.txt");
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			String line;
			int[] nums = { 5,30,1,8,8,10,11,15,15,12 };
			while((line = br.readLine())!= null) {
				int beginIndex = 0;
				for(int j = 0; j < nums.length; j++) {
					int endIndex = beginIndex + nums[j];
					sb.append(line.substring(beginIndex, endIndex));
					if(nums.length > j + 1) {
						sb.append(",");
					}
					beginIndex = endIndex;
				}
				sb.append("\n");
			}
			fr.close();
			System.out.println(sb.toString());
			
			PrintWriter writer = new PrintWriter(new File("/Users/sucherrywine/Documents/UnionTec/労働者名簿_固定長_Csv.txt")); 
			writer.write(sb.toString());
			writer.flush();
			writer.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
