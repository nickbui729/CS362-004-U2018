import junit.framework.TestCase;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
      
      UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
      assertFalse("No digit in an ip address should be above 255", urlVal.isValid("http://1.2.3.400/"));
      assertTrue("Lower bounds should be a valid IP address", urlVal.isValid("1.1.1.1")); 
      assertTrue("Should be a valid IP address", urlVal.isValid("1.1.1.255")); 
      assertTrue("Should be a valid IP address", urlVal.isValid("3.3.3.100")); 
      assertTrue("Should be a valid IP address", urlVal.isValid("3.3.3.255")); 
      assertFalse("Invalid IP address", urlVal.isValid("3.3.3.256")); 

	   
   }
   
   
   public void testYourFirstPartition()
   {
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       assertEquals(true, "http://foo.com/blah_blah");  //valid scheme
       //You can use this function to implement your First Partition testing

   }
   
   public void testYourSecondPartition(){
       UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
       assertEquals(false, "foo.com"); //no scheme
       //You can use this function to implement your Second Partition testing

   }
    public void testYourThirdPartition(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertEquals(false, "http://fo o.bar"); //invalid authority
        //http:example.com/foo/foo/foo?bar/bar/bar
        //You can use this function to implement your Second Partition testing

    }

    public void testYourFourthPartition(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertEquals(false, "http://foo.bar"); //valid authority
        //http:example.com/foo/foo/foo?bar/bar/bar
        //You can use this function to implement your Second Partition testing

    }

    public void testYourFifthPartition(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertEquals(true, "http://example.com/foo/foo/foo?bar/bar/bar"); //with query
        //You can use this function to implement your Second Partition testing

    }

    public void testYourSixthPartition(){
        UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        assertEquals(true, "http://example.com/foo/foo/foo?ba r/bar/bar"); //with invalid query
        //You can use this function to implement your Second Partition testing

    }

    //You need to create more test cases for your Partitions if you need to
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

      String schemes[] = new String [4];
      schemes[0]= "http://";
      schemes[1]= "asdf";
      schemes[2]= "ftp://";
      schemes[3]= "http:";

       UrlValidator url = new UrlValidator(schemes, null, UrlValidator.ALLOW_2_SLASHES);

       String authority[] = new String [4];
       authority[0]= "www.google.com";
       authority[1]= "twitter.com";
       authority[2]= "fasasdf";
       authority[3]= "123.4";

       String port[] = new String [4];
       port[0]= ":0";
       port[1]= "";
       port[2]= "asdfafdsff";
       port[3]= "-1";

       String path[] = new String [4];
       path[0]= "/t123";
       path[1]= "";
       path[2]= "merp";
       path[3]= "kjjklj";

       String query[] = new String [3];
       query[0]= "";
       path[1]= "gibberish";
       path[2]= "ewrerw";

       String testurl;
       boolean result;

       for (int i = 0; i < 4; i = i+1){
           for (int j = 0; j < 4; j++){
               for (int k = 0; k < 4; k++){
                   for (int m = 0; m < 4; m++){
                       for (int n = 0; n < 3; n++){

                           testurl = schemes[i] + authority[j]+ port[k] +path[m] + query[n];

                           if (i < 4 && j < 2 && k < 2 && m < 2 && n < 1) {
                               result = url.isValid(testurl);

                           }
                           else{
                               assertEquals(false, url.isValid(testurl));
                           }

                       }
                   }
               }
           }

       }



   }

   public void testIsValid2()
   {

       UrlValidator url = new UrlValidator(null, null, UrlValidator.ALLOW_2_SLASHES);

       String schemes[] = new String [4];
       schemes[0]= "http://";
       schemes[1]= "ftp://";
       schemes[2]= "asdf";
       schemes[3]= "http:";

       String authority[] = new String [4];
       authority[0]= "www.google.com";
       authority[1]= "twitter.com";
       authority[2]= "fasasdf";
       authority[3]= "123.4";

       String port[] = new String [4];
       port[0]= ":0";
       port[1]= "";
       port[2]= "asdfafdsff";
       port[3]= "-1";

       String path[] = new String [4];
       path[0]= "/t123";
       path[1]= "";
       path[2]= "merp";
       path[3]= "kjjklj";

       String query[] = new String [3];
       query[0]= "";
       path[1]= "gibberish";
       path[2]= "ewrerw";

       String testurl;
       boolean result;

       for (int i = 0; i < 4; i = i+1){
           for (int j = 0; j < 4; j++){
               for (int k = 0; k < 4; k++){
                   for (int m = 0; m < 4; m++){
                       for (int n = 0; n < 3; n++){

                           testurl = schemes[i] + authority[j]+ port[k] +path[m] + query[n];


                           if (i < 2 && j < 2 && k < 2 && m < 2 && n < 1) {
                               result = url.isValid(testurl);

                           }
                           else{
                               assertEquals(false, url.isValid(testurl));
                           }

                       }
                   }
               }
           }

       }



   }



   public void testIsValid3()
   {


       UrlValidator url = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

       String schemes[] = new String [4];
       schemes[0]= "http://";
       schemes[1]= "asdf";
       schemes[2]= "ftp://";
       schemes[3]= "http:";

       String authority[] = new String [4];
       authority[0]= "www.google.com";
       authority[1]= "twitter.com";
       authority[2]= "fasasdf";
       authority[3]= "123.4";

       String port[] = new String [4];
       port[0]= ":0";
       port[1]= "";
       port[2]= "asdfafdsff";
       port[3]= "-1";

       String path[] = new String [4];
       path[0]= "/t123";
       path[1]= "";
       path[2]= "merp";
       path[3]= "kjjklj";

       String query[] = new String [3];
       query[0]= "";
       path[1]= "gibberish";
       path[2]= "ewrerw";

       String testurl;
       boolean result;

       for (int i = 0; i < 4; i = i+1){
           for (int j = 0; j < 4; j++){
               for (int k = 0; k < 4; k++){
                   for (int m = 0; m < 4; m++){
                       for (int n = 0; n < 3; n++){

                           testurl = schemes[i] + authority[j]+ port[k] +path[m] + query[n];



                           if (i < 4 && j < 2 && k < 2 && m < 2 && n < 1) {
                               result = url.isValid(testurl);
                           }
                           else{
                               assertEquals(false, url.isValid(testurl));
                           }

                       }
                   }
               }
           }

       }

   }



}