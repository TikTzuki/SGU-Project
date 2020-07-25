
package BUS;

import DAO.DAOCustomer_tran;
import DTO.Customer;
import GUI.Validation;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */

public class BUSCustomer_tran 
{
    private ArrayList<Customer> arrCus;
    private DAOCustomer_tran DAOCus = new DAOCustomer_tran();

    public BUSCustomer_tran()
    {
        
    }
    
    public ArrayList list() 
    {
        if(arrCus == null)
        {
            arrCus = new ArrayList<Customer>();
        }
        
        arrCus = DAOCus.list();
        return arrCus;
    }
    
    public void add(Customer DTOCus) 
    { 
        DAOCus.add(DTOCus);
        arrCus.add(DTOCus);
    }
    
    public void edit(Customer DTOCus)
    {
        while(DTOCus.getFirst_name().equals("") || DTOCus.getLast_name().equals("") || DTOCus.getEmail().equals("")
                || DTOCus.getPhone_number().equals("") || DTOCus.getAddress().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin");
            return;
        }
        
        for(int i = 0; i < arrCus.size(); i++)
        {
            if(arrCus.get(i).getCustomer_id() == DTOCus.getCustomer_id())
            {
                arrCus.set(i, DTOCus);
                DAOCus.edit(DTOCus);
                return;
            }
        }
    }
    
    public void del(int CusID)
    {
        for(Customer DTOCus : arrCus)
        {
            if(DTOCus.getCustomer_id() == CusID)
            {
                arrCus.remove(DTOCus);
                DAOCus.del(CusID);
                return;
            }
        }
    }
    
    
}
