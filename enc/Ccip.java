package enc;
import java.util.*;
public class Ccip
{
     private final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
     public String encrypt(String plainText,int shiftKey)
     {
           plainText = plainText.toLowerCase();
           String cipherText="";
           for(int i=0;i<plainText.length();i++)
           {
                int charPosition = ALPHABET.indexOf(plainText.charAt(i));
                int keyVal = (shiftKey+charPosition)%26;
                char replaceVal = this.ALPHABET.charAt(keyVal);
                cipherText += replaceVal;
           }
           return cipherText;
     }
     public String decrypt(String cipherText, int shiftKey)
     {
           cipherText = cipherText.toLowerCase();
           String plainText="";
           for(int i=0;i<cipherText.length();i++)
           {
                int charPosition = this.ALPHABET.indexOf(cipherText.charAt(i));
                int keyVal = (charPosition-shiftKey)%26;
                if(keyVal<0)
                {
                      keyVal = this.ALPHABET.length() + keyVal;
                }
                char replaceVal = this.ALPHABET.charAt(keyVal);
                plainText += replaceVal;
           }
           return plainText;
     }
public int countWords(String s)
{
    int wordCount = 0;
    boolean word = false;
    int endOfLine = s.length() - 1;
    for (int i = 0; i < s.length(); i++) 
{
        // if the char is a letter, word = true.
        if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
            word = true;
            // if char isn't a letter and there have been letters before,
            // counter goes up.
        } else if (!Character.isLetter(s.charAt(i)) && word) {
            wordCount++;
            word = false;
            // last word of String; if it doesn't end with a non letter, it
            // wouldn't count without this.
        } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
            wordCount++;
        }
    }
    return wordCount;
}

public int keygen(String pt)
{  
    Map dash=new HashMap();
    Map dot = new HashMap(); 
      dot.put('a', 1);
      dot.put('b', 3);
      dot.put('c', 2);
      dot.put('d', 2);
      dot.put('e', 1);
      dot.put('f', 2);
      dot.put('g', 1);
      dot.put('h', 4);
      dot.put('i', 2);
      dot.put('j', 1);
      dot.put('k', 1);
      dot.put('l', 3);
      dot.put('m', 0);
      dot.put('n', 1);
      dot.put('o', 0);
      dot.put('p', 2);
      dot.put('q', 1); 
      dot.put('r', 2); 
     dot.put('s', 3);
     dot.put('t', 0);
    dot.put('u', 2);
    dot.put('v', 3);
     dot.put('w', 1);
     dot.put('x', 2);
     dot.put('y', 1);
      dot.put('z', 2);
 
      dash.put('a', 1);
      dash.put('b', 1);
      dash.put('c', 2);
      dash.put('d', 1);
      dash.put('e', 0);
      dash.put('f', 1);
      dash.put('g', 2);
      dash.put('h', 0);
      dash.put('i', 0);
      dash.put('j', 3);
      dash.put('k', 2);
      dash.put('l', 1);
      dash.put('m', 2);
      dash.put('n', 1);
      dash.put('o', 3);
      dash.put('p', 2);
      dash.put('q', 3); 
      dash.put('r', 1); 
     dash.put('s', 0);
     dash.put('t', 1);
    dash.put('u', 1);
    dash.put('v', 1);
     dash.put('w', 2);
     dash.put('x', 2);
     dash.put('y', 3);
      dash.put('z', 2);
   System.out.println();
/* System.out.println("\n Enter your plain text>>\n"); 
      String pt=(s.nextLine()).toLowerCase();*/
 int start=0,end=(pt.length()-1),c,d,key;       
  do
{
      c=(int)dot.get((pt.charAt(start)));
      d=(int)dash.get((pt.charAt(end)));
      key=c+d;
      start++;
      end--;
}while(key==0);
 //System.out.println("key value for Value for "+pt+" is "+(c+d));
 return key;
   }

public String keyen(int kar[]) 
 {
 int l=kar.length;
 int kas[]=new int[l];
 System.arraycopy(kar,0,kas,0,l);
 int sum=0;String ck=" ";
 Map ka=new HashMap();
      ka.put(1,"a");
      ka.put(2,"b");
      ka.put(3,"c");
      ka.put(4,"d");
      ka.put(5,"e");
      ka.put(6,"f");
      ka.put(7,"g");
      ka.put(8,"h");
      ka.put(9,"i");
      ka.put(10,"j");
      ka.put(11,"k");
      ka.put(12,"l");
      ka.put(13,"m");
      ka.put(14,"n");
      ka.put(15,"o");
      ka.put(16,"p");
      ka.put(17,"q"); 
      ka.put(18,"r"); 
      ka.put(19,"s");
      ka.put(20,"t");
      ka.put(21,"u");
      ka.put(22,"v");
      ka.put(23,"w");
      ka.put(24,"x");
      ka.put(25,"y");
      ka.put(26,"z"); 
/*Scanner s=new Scanner(System.in); 
 System.out.println("\n Enter the array elements>>\n");
    for(int i=0;i<kas.length;i++)
 {
  kas[i]=s.nextInt();
 }
System.out.println("Array elements are>>\n"); 
  for(int i=0;i<kas.length;i++)
 {
  System.out.println(" "+kas[i]);
 }*/
 for(int i=0;i<kas.length;i++)
{
  sum=sum+kas[i];
 }
 System.out.println("\n The sum is>> "+sum);
  System.out.println(" \n We will begin from the "+sum+"th letter"); 
 ck=(String)ka.get(sum);
 System.out.println(" "+ck);
for(int i=0;i<kas.length;i++)
{
 int temp=sum+((kas[i])+1);
 ck=ck+(String)ka.get(temp);
}
return ck;
}

/*public int[] regenkey(String enck)
{
 String temp=enck;int i;
 char c,c2; 
 int keyar[]=new int[enck.length()];
 Map ka=new HashMap();
      ka.put('a',1);
      ka.put('b',2);
      ka.put('c',3);
      ka.put('d',4);
      ka.put('e',5);
      ka.put('f',6);
      ka.put('g',7);
      ka.put('h',8);
      ka.put('i',9);
      ka.put('j',10);
      ka.put('k',11);
      ka.put('l',12);
      ka.put('m',13);
      ka.put('n',14);
      ka.put('o',15);
      ka.put('p',16);
      ka.put('q',17); 
      ka.put('r',18); 
      ka.put('s',19);
      ka.put('t',20);
      ka.put('u',21);
      ka.put('v',22);
      ka.put('w',23);
      ka.put('x',24);
      ka.put('y',25);
      ka.put('z',26); 
     c=enck.charAt(0);
     i=(int)ka.get(c);
     for(int j=1;j<enck.length();j++)
     {
     c2=enck.charAt(j);
     keyar[i]=Math.abs(i-((int)ka.get(c2))+1);
     }
return keyar;
}*/
}
