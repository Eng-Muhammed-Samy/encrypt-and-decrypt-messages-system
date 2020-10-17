
package encrpt_yasn;
import java.io.*;



public class Encrpt_yasn {

    public static char[] encryptArray( char[] normalArray, char[] key){
        //note:the key size is four digits
        //create the encrypted array with the same size as the normal message/array
        char[] encArray = new char[normalArray.length];
        
         //create the key array with the same size as the normal message/array
        char[] keyArray = new char[normalArray.length];
        
        //the key indicator indicates which key element we are in std = 1
        int indicator = 1;
       
        
        
        //create the key array
        //we subtract 48 because the ASCII code of 0 is 48
        for(int i=0; i<keyArray.length; i++){
        switch(indicator){
            case 1:
                keyArray[i] = (char) (key[0] - 48);
                indicator++;
                break;
                
            case 2:
                keyArray[i] = (char) (key[1] - 48);
                indicator++;
                break;
                
            case 3:
                keyArray[i] = (char) (key[2] - 48);
                indicator++;
                break; 
            
            case 4:
                keyArray[i] = (char) (key[3] - 48);
                indicator=1;
                break;    
            
            default:  System.out.println("error in indc value!");
                
        }
        }
        
        //add the key to the normal msg to encrypt the msg
        for(int i=0; i<encArray.length; i++){
            
            encArray[i] = (char) (normalArray[i] + keyArray[i]);
            
        }
        
        //return the encrypted array
        return encArray;
        
    }
    
    //same as the previous function but we subtract the key at the end
    //don't look at the comments i just copied it :)
     public static char[] decryptArray( char[] encArray, char[] key){
        //note:the key size is four digits
        //create the encrypted array with the same size as the normal message/array
        char[] normalArray = new char[encArray.length];
        
         //create the key array with the same size as the normal message/array
        char[] keyArray = new char[encArray.length];
        
        //the key indicator indicates which key element we are in std = 1
        int indicator = 1;
        
        /////////
        
        
        //create the key array
        for(int i=0; i<keyArray.length; i++){
        switch(indicator){
            case 1:
                keyArray[i] = (char) (key[0] - 48);
                indicator++;
                break;
                
            case 2:
                keyArray[i] = (char) (key[1] - 48);
                indicator++;
                break;
                
            case 3:
                keyArray[i] = (char) (key[2] - 48);
                indicator++;
                break; 
            
            case 4:
                keyArray[i] = (char) (key[3] - 48);
                indicator=1;
                break;    
            
            default:  System.out.println("error in indc value!");
                
        }
        }
        
        //add the key to the normal msg to encrypt the msg
        for(int i=0; i<encArray.length; i++){
            
            normalArray[i] = (char) (encArray[i] - keyArray[i]);
            
        }
        
        //return the encrypted array
        return normalArray;
        
    }
    
    public static void main(String[] args)  throws IOException {
        

        
        
        //read the normal message
        char[] Msg = new char[2000];
       
         int i = 0;
         FileInputStream  in  = null;
         
         
         try {
         in = new FileInputStream("Message.txt");
         
         
         int c;
         while ((c = in.read()) != -1) {
           Msg[i] = (char)c; 
           i++;
         }
      }finally {
         if (in != null) {
            in.close();
         }
         
      }
         
       //encription key
       String key = "4568";
       char[] keyCh = key.toCharArray();
         
      //encrypt the normal message
      char[] encMsg = encryptArray(Msg, keyCh);  
      
      //output the encrypted message to a file
      int j = 0;
         FileOutputStream  out  = null;
         
         
         try {
         out = new FileOutputStream("ecnryptedMessage.txt");
         
         
         
         while (j<encMsg.length) {
         out.write(encMsg[j]);
         j++;
         }
      }finally {
         if (out != null) {
            out.close();
         }
         
      }
         
      //read the encrypted message
      char[] encMsg2 = new char[2000];
       
         int k = 0;
         FileInputStream  in_  = null;
         
         
         try {
         in_ = new FileInputStream("ecnryptedMessage.txt");
         
         
         int c2;
         while ((c2 = in_.read()) != -1) {
           encMsg2[k] = (char)c2; 
           k++;
         }
      }finally {
         if (in_ != null) {
            in_.close();
         }
         
      }
         
       //decrypt the message you just read
         
       char[] finalArr = decryptArray(encMsg2, keyCh); 
       
       
       
       
       //Write the decrypted message to a file
        int j2 = 0;
         FileOutputStream  out2  = null;
         
         
         try {
         out2 = new FileOutputStream("decryptedMessage.txt");
         
         
         
         while (j2<finalArr.length) {
         out2.write(finalArr[j2]);
         j2++;
         }
      }finally {
         if (out2 != null) {
            out2.close();
         }
         
      } 
         
         //Alhamd llah
         //All graices to God
    }
    
}
