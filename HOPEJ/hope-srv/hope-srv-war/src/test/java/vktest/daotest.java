package vktest;

import org.junit.Before;
import org.junit.Test;
import com.gmail.vkorshun.DAO.BaseDAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.math.BigDecimal;
import java.util.Properties;

/**
 * Created by vkorshun on 16.04.2016.
 */
public class daotest {

  @Before
  public void setUpClass() throws Exception {
    System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
        "org.apache.naming.java.javaURLContextFactory");
    System.setProperty(Context.URL_PKG_PREFIXES,
        "org.apache.naming");

    Context ic = new InitialContext();
    ic.createSubcontext("java:");
    ic.createSubcontext("java:/comp");
    ic.createSubcontext("java:/comp/env");
    ic.createSubcontext("java:/comp/env/jdbc");

    Properties properties = new Properties();
    properties.load(this.getClass().getResourceAsStream("test.conf"));
    System.getProperties().load(this.getClass().getResourceAsStream("test.conf"));
    //ic.bind("java:/comp/env/jdbc/DSTest", mock(DataSource.class));
    //loadSystemProperties();
//    InitialContext ic = new InitialContext();
//    ic.createSubcontext("java:");    /**заглучшки*/
    // JAXBContext context = JAXBContext.newInstance("ua.com.csltd.ifobs.ws.soapPireus");
    // ifobsConst.isLicenseReaded = true;
  }

  @Test
  public void test(){
    BaseDAO dao = new BaseDAO();
    String name  = dao.getObjectName(new BigDecimal("1"));
    System.out.println(name);

    /*Timestamp now = new Timestamp(System.currentTimeMillis());
    String s = "11, 22,33";
    List<Integer> test = MikkoCurrencyList.getList(s);
    test.add(0);*/
//    KursLoaderKZ kz = new KursLoaderKZ(now, now);
    try {
//      kz.checkKurs();
    } catch (Exception e) {
      e.printStackTrace();
    }

    /*byte[] rr = MikkoPasswordUtils.preparePassword("123","vk");
    try {
      byte[] rr2 = VkStringUtils.dosToWin(rr);
      String s = new String(rr2);
    } catch (Exception e) {
      e.printStackTrace();
    }*/
  }

  private byte[] dosToWin(byte[] b){
    byte[] arb1= new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,-128,-127,-126,-125,-124,-123,-122,-121,-120,-119,-118,-117,-116,-115,-114,-113,-112,-111,-110,-109,-108,-107,-106,-105,-104,-103,-102,-101,-100,-99,-98,-97,-96,-95,-94,-93,-92,-91,-90,-89,-88,-87,-86,-85,-84,-83,-82,-81,-80,-79,-78,-77,-76,-75,-74,-73,-72,-71,-70,-69,-68,-67,-66,-65,-64,-63,-62,-61,-60,-59,-58,-57,-56,-55,-54,-53,-52,-51,-50,-49,-48,-47,-46,-45,-44,-43,-42,-41,-40,-39,-38,-37,-36,-35,-34,-33,-32,-31,-30,-29,-28,-27,-26,-25,-24,-23,-22,-21,-20,-19,-18,-17,-16,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
    byte[] arb2= new byte[]{79,79,-90,-90,-90,-90,-107,-107,48,48,62,43,100,100,48,62,60,-90,33,-74,-89,45,-90,94,118,62,60,76,45,94,-95,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,-90,-64,-63,-62,-61,-60,-59,-58,-57,-56,-55,-54,-53,-52,-51,-50,-49,-48,-47,-46,-45,-44,-43,-42,-41,-40,-39,-38,-37,-36,-35,-34,-33,-32,-31,-30,-29,-28,-27,-26,-25,-24,-23,-22,-21,-20,-19,-18,-17,45,45,45,-90,43,-90,-90,-84,-84,-90,-90,-84,45,45,45,-84,76,43,84,43,45,43,-90,-90,76,-29,-90,84,-90,61,43,-90,-90,84,84,76,76,45,-29,43,43,45,45,45,45,-90,-90,45,-16,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,-88,-72,-86,-70,-81,-65,-95,-94,-80,-107,-73,118,-71,-92,-90,-96};
    for (int i=0;i<b.length;i++){
      for (int j=0; j< arb1.length; j++){
        if (arb1[j]==b[i]) {
          b[i] = arb2[j];
          break;
        }
      }
    }
    return b;
  }
}


