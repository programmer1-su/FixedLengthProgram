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
			FileInputStream fis = new FileInputStream("/Users/sucherrywine/Documents/UnionTec/file_layout.txt");//rawバイトのストリームを読み込むときは、FileInputStreamを使用してください。
			//FileInputStream is useful to read data from a file in the form of sequence of bytes. 
			//FileInputStream is meant for reading streams of raw bytes such as image data.
			Scanner sc = new Scanner(fis);//to read text files
			String[] nums = {};
			// iterate till end 
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				nums = line.split(",");
			}
			sc.close();
			File file = new File("/Users/sucherrywine/Documents/UnionTec/労働者名簿_固定長.txt");//specify the filename
			FileReader fr = new FileReader(file);//FileReaderは、文字のストリームを読み込むために使用されます。
			BufferedReader br = new BufferedReader(fr);
			// StringBufferを宣言する
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null) {
				int beginIndex = 0;
				for (int i = 0; i < nums.length; i++) {
					int endIndex = beginIndex + Integer.parseInt(nums[i]);
					sb.append(line.substring(beginIndex, endIndex));
					if (nums.length > i + 1) {
						sb.append(",");// appendメソッドを使用して、commaを結合する
					}
					beginIndex = endIndex;
				}
				sb.append("\n");
			}
			fr.close();
			//Javaにはファイルの書き込みを行うFileWriterクラスがあります。FileWriterクラスを使って新しいテキストファイルを作ったり、すでに存在するテキストファイルに追加で文字を書き込むことができます。
			PrintWriter writer = new PrintWriter(new File("/Users/sucherrywine/Documents/UnionTec/労働者名簿_固定長_CSV.txt"));
			//行の自動フラッシュは行わずに、指定されたファイルで新しいPrintWriterを作成します。
			writer.write(sb.toString());
			writer.flush();// flush the writer
			writer.close();// flush the stream again
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
//BufferedReaderとは
//BufferedReaderクラスとは、テキストファイルを読み込むためのクラスです。

//BufferedReaderクラスでは、テキストファイルを1行ずつ読み込むreadlineメソッドが用意されています。

//テキストファイルを読み込むクラスにはFileReaderクラスもありますが、こちらはテキストを1文字ずつ読み込むため効率が悪い場合があります。

//そのため、テキストファイルの読み込みはBufferedReaderクラスを使うようにしましょう。

//BufferedReaderの使い方
//ここでは、BufferedReaderクラスのreadLineメソッドを使って、テキストファイルを1行ずつ読み込む方法を解説します。

//readLineメソッドは指定したテキストファイルを1行ずつ読み込み、String型の戻り値として返します。

//ファイルの終わりに到達した場合は「null」を返します。

//そのため、ファイルの終わりまで読み込む場合には、while文でnullが返されるまでループさせます。

//テキストファイルを1行ずつ読み込む方法について、次のプログラムで確認してみましょう。

//StringBufferとは
//StringBufferクラスは、Stringクラス同様に宣言した変数に文字列を格納するために使用します。

//Stringクラスとの違いとして、変数に文字列を格納したあとでも「値を追加」「挿入」「変更」などの、文字列操作が可能なことが挙げられます。

//つまり、StringBufferクラスは、文字列の値が「不変である」と分かっているときに、使用するケースが多いと言えます。
