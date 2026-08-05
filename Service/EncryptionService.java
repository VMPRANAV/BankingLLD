package Service;

public class EncryptionService {
    public String encrypt(String password){
StringBuilder sb= new StringBuilder();
for(char c:password.toCharArray()){
   if(c>='a' && c<='z'){
    c=(c=='z')?'a':(char)(c+1);
   }
   else if(c>='A' && c<='Z'){
     c=(c=='Z')?'A':(char)(c+1);
   }
   else if(c>='0' && c<='9'){
c=(c=='9')?'0':(char)(c+1);
   }
    sb.append(c);

}
return sb.toString();
    }
     public String decrypt(String password){
StringBuilder sb= new StringBuilder();
for(char c:password.toCharArray()){
     if(c>='a' && c<='z'){
    c=(c=='a')?'z':(char)(c-1);
   }
   else if(c>='A' && c<='Z'){
     c=(c=='A')?'Z':(char)(c-1);
   }
   else if(c>='0' && c<='9'){
c=(c=='0')?'9':(char)(c-1);
   }
    sb.append(c);

}
return sb.toString();
    }

}
