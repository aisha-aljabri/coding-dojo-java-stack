public class StringManipulator{
    public String trimAndConcat(String x, String y){
        return x.trim().concat(y.trim());
    }

    public Integer getIndexOrNull(String str, char ch){
        if (str.indexOf(ch) >= 0){
            return str.indexOf(ch);
        }
        else {
            return null;
        }
    }

    public Integer getIndexOrNull(String str1, String str2){
        if (str1.indexOf(str2) >= 0){
            return str1.indexOf(str2);
        }
        else{
            return null;
        }
    }

    String concatSubstring(String str1, int i1, int i2, String str2){
        return str1.substring(i1, i2).concat(str2);
    }
}