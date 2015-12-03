import java.util.* ;
Vector clients = new Vector();
Client cl =new Client();
clients.addElement(cl);
for (int i=0; i<clients.size();i++){
 ((Client)(clients.elementAt(i))).name;
}
clients.removeElement(cl);
clients.toString(); 
