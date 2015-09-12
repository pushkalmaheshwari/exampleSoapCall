package march10october.com.soaptest;

import android.util.Log;
import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.IOException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;


public class SoapRequests {

    private static final boolean DEBUG_SOAP_REQUEST_RESPONSE = true;
    private static final String MAIN_REQUEST_URL = "http://192.168.1.105:8080/WS/HelloWorld";
    private static final String NAMESPACE = "http://JaxWS.pushkal.org/";
    private static final String SOAP_ACTION = "http://192.168.1.105:8080/WS/HelloWorld/";
    private static String SESSION_ID;

    private final void testHttpResponse(HttpTransportSE ht) {
        ht.debug = DEBUG_SOAP_REQUEST_RESPONSE;
        if (DEBUG_SOAP_REQUEST_RESPONSE) {
            Log.v("SOAP RETURN", "Request XML:\n" + ht.requestDump);
            Log.v("SOAP RETURN", "\n\n\nResponse XML:\n" + ht.responseDump);
        }
    }

    public String getCelsiusConversion(String fValue) {
        String data = null;
        String methodname = "GetCategoryById";

        SoapObject request = new SoapObject(NAMESPACE, methodname);
//input
        PropertyInfo p = new PropertyInfo();
        p.setName("arg0");
        p.setValue(fValue);
        p.setType(String.class);
        request.addProperty(p);

        // output
        Category C = new Category();
//        C.CategoryId = 1;
//
//        PropertyInfo pi = new PropertyInfo();
//        pi.setName("Category");
//        pi.setValue(C);
//        pi.setType(C.getClass());
//        request.addProperty(pi);


        SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

        envelope.addMapping(NAMESPACE, "Category",new Category().getClass());


        HttpTransportSE ht = getHttpTransportSE();
        try {
            ht.call(SOAP_ACTION + methodname, envelope);
            testHttpResponse(ht);
            SoapObject response = (SoapObject)envelope.getResponse();
            Category category = RetrieveFromSoap(response);
            String resultsString = getDisplayString(category);

            List<HeaderProperty> COOKIE_HEADER = (List<HeaderProperty>) ht.getServiceConnection().getResponseProperties();

            for (int i = 0; i < COOKIE_HEADER.size(); i++) {
                String key = COOKIE_HEADER.get(i).getKey();
                String value = COOKIE_HEADER.get(i).getValue();

                if (key != null && key.equalsIgnoreCase("set-cookie")) {
                    SoapRequests.SESSION_ID = value.trim();
                    Log.v("SOAP RETURN", "Cookie :" + SoapRequests.SESSION_ID);
                    break;
                }
            }
            data = resultsString;

        } catch (SocketTimeoutException t) {
            t.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (Exception q) {
            q.printStackTrace();
        }
        return data;
    }

    private String getDisplayString(Category c) {

            return "CategoryId: " + c.CategoryId + " Name: " + c.Name + " Description " + c.Description;
    }

    private final SoapSerializationEnvelope getSoapSerializationEnvelope(SoapObject request) {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        //envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.setAddAdornments(false);
        envelope.setOutputSoapObject(request);
        return envelope;
    }

    private final HttpTransportSE getHttpTransportSE() {
        HttpTransportSE ht = new HttpTransportSE(Proxy.NO_PROXY,MAIN_REQUEST_URL,60000);
        ht.debug = true;
        ht.setXmlVersionTag("<?xml version=\"1.0\" encoding= \"UTF-8\" ?>");
        return ht;
    }

    private final List<HeaderProperty> getHeader() {
        List<HeaderProperty> header = new ArrayList<HeaderProperty>();
        HeaderProperty headerPropertyObj = new HeaderProperty("cookie", SoapRequests.SESSION_ID);
        header.add(headerPropertyObj);

        HeaderProperty headerPropertyObj1 =  new HeaderProperty("Content-Type", "text/xml; charset=utf-8");
        header.add(headerPropertyObj1);
        return header;
    }

    public static Category RetrieveFromSoap(SoapObject  pii)
    {

            Category category = new Category();

            category.CategoryId  = Integer.parseInt(pii.getProperty("CategoryId").toString());

            SoapObject stockSoapObject = (SoapObject) pii.getProperty("Stocks");
            String myvalue = stockSoapObject.getProperty("sku").toString();
            String myvalue2 = stockSoapObject.getProperty("color").toString();


        return category;
    }
}