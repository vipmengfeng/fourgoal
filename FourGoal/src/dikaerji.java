import java.util.ArrayList;
import java.util.List;

public class dikaerji {
	 public String[] str1 = { "3","2", "1", "0" };
	 public String[] str2 = { "3","2", "1", "0" };
	 public String[] str3 = { "3","2", "1", "0" };
	 public String[] str4 = { "3","2", "1", "0" };
	 public String[] str5 = { "3","2", "1", "0" };
	 public String[] str6 = { "3","2", "1", "0" };
	 public String[] str7 = { "3","2", "1", "0" };
	 public String[] str8 = { "3","2", "1", "0" };

 public void dikaerjistart (List<String> result) {
  List<String[]> list = new ArrayList<String[]>();
  list.add(str1);
  list.add(str2);
  list.add(str3);
  list.add(str4);
  list.add(str5);
  list.add(str6);
  list.add(str7);
  list.add(str8);
  Descartes(list, 0, result, "");
   
 }
 private  String Descartes(List<String[]> list, int count,
   List<String> result, String data) {
  String temp = data;
  String[] astr = list.get(count);
  // foreach (var item in astr)
  for (int i = 0; i < astr.length; i++) {
   if (count + 1 < list.size()) {
    temp += Descartes(list, count + 1, result, data + astr[i]);
   } else {
    result.add(data + astr[i]);
   }
  }
  return temp;
 }
}


