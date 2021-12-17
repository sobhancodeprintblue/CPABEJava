
package pbe;

/**
 *
 * @author Mohammad
 */
import co.junwei.cpabe.Cpabe;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


public class CPABE_Java {
        Cpabe test=new Cpabe();
        static String pubfile = "D:\\pubfile.txt";
	static String mskfile ="D:\\mskfile.txt";
	static String prvfile ="D:\\prvfile.txt";

	static String inputfile ="D:\\inputfile.txt";
	static String encfile = "D:\\encfile.txt";
	static String decfile = "D:\\decfile.txt";
        
        static String student_attr = "objectClass:inetOrgPerson objectClass:organizationalPerson "+ "sn:student2 cn:student2 uid:student2 userPassword:student2 "+ "ou:idp o:computer mail:student2@sdu.edu.cn title:student";

	static String student_policy = "sn:student2 cn:student2 uid:student2 3of3";
        
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, Exception {
        // TODO code application logic here
        
        Cpabe test = new Cpabe();
                
		System.out.println("//start to setup");
                Long t1=System.currentTimeMillis();
		test.setup(pubfile, mskfile);
                Long t2=System.currentTimeMillis()-t1;
                System.out.println("Setup Time= "+t2.toString());
		System.out.println("//end to setup");

		System.out.println("//start to keygen");
                t1=System.currentTimeMillis();
		test.keygen(pubfile, prvfile, mskfile, student_attr);
                t2=System.currentTimeMillis()-t1;
                System.out.println("Keygen Time= "+t2.toString());
		System.out.println("//end to keygen");

		System.out.println("//start to enc");
                t1=System.currentTimeMillis();
		test.enc(pubfile, student_policy, inputfile, encfile);
                t2=System.currentTimeMillis()-t1;
                System.out.println("Encryption Time= "+t2.toString());
		System.out.println("//end to enc");

		System.out.println("//start to dec");
                t1=System.currentTimeMillis();
		test.dec(pubfile, prvfile, encfile, decfile);
                t2=System.currentTimeMillis()-t1;
                System.out.println("Decryption Time= "+t2.toString());
		System.out.println("//end to dec");

        
    }
    
}
