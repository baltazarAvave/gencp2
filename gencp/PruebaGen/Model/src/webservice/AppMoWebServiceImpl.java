package webservice;

import javax.xml.rpc.ServiceFactory;

import webservice.common.AppMoWebService;

import oracle.jbo.server.ApplicationModuleImpl;

import webservice.proxy.TestGenPortClient;
import webservice.proxy.TestGenService;


// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Oct 23 10:38:13 PYST 2011
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AppMoWebServiceImpl extends ApplicationModuleImpl implements AppMoWebService {
    /**
     * This is the default constructor (do not remove).
     */
    public AppMoWebServiceImpl() {
    }
    
    /**
     * genera y guarda el diagrama de actividades desde el template
     * @param templateDir
     * @param activityDiagramDir
     * @return
     */
    public String WSGenerarActivityDiagram(String templateDir, String activityDiagramDir){
        String result = "";
        TestGenService varWS;
        String out = "";
        try{
            System.out.println("templateDir-->"+templateDir);
            System.out.println("activityDiagramDir-->"+activityDiagramDir);
            varWS = new TestGenService();
            out = varWS.getTestGenPort().generarActivityDiagram(templateDir,activityDiagramDir);
            
            if ( out.equals("OK") ){
                result = "Archivo creado Exitosamente";
            }else{
                result = "Error en la comunicacion con WSTestGen, al invocar al m�todo WSGenerarActivityDiagram"+out;
            }
            
        }catch(Exception e){
            result = e.getLocalizedMessage();            
        }
        
        return result;
    }

    /**
     * genera las secuencias desde el diagrama de actividades
     * @param templateDir
     * @return
     */
    public String WSGenerarSecuencias(String templateDir, String testObjectiveFile){
        String result = "";
        TestGenService varWS;
        String out = "";
        try{
            System.out.println("templateDir-->"+templateDir);
            System.out.println("testObjectiveFile-->"+testObjectiveFile);
            varWS = new TestGenService();
            out = varWS.getTestGenPort().generarSecuencias(templateDir, testObjectiveFile);
            result = out; //retorna la lista en un string, si es generada correctamente
            
        }catch(Exception e){
            result = e.getLocalizedMessage();            
        }
        
        return result;
    }
    
    /*private String imprimirTestObjectiveList(TestObjectiveList tol){
            StringBuffer sb = new StringBuffer("");
            int c;
            
            sb.append("Test objectives: " + to.size () + "\n");
            sb.append("=======================\n");
            for ( c = 0; c < to.size (); c++ ) {
                sb.append ((c+1) + "::: " + this.to.get (c) + "\n");
            }
            sb.append("Loops:\n");
            for ( c = 0; c < this.loopNumer(); c++ ) {
                sb.append ((c+1) + ": " + this.loops.get(c) + "\n");
            }
            
            return sb.toString ();
        }*/
}
