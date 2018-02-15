package mysd;

import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class C_CMBMonth extends JComboBox{
	public C_CMBMonth(){
		super();
		this.addItem((String)"01-January");
		this.addItem((String)"02-February");
		this.addItem((String)"03-March");
		this.addItem((String)"04-April");
		this.addItem((String)"05-May");
		this.addItem((String)"06-June");
		this.addItem((String)"07-July");
		this.addItem((String)"08-August");
		this.addItem((String)"09-September");
		this.addItem((String)"10-October");
		this.addItem((String)"11-November");
		this.addItem((String)"12-December");
	}


    public String getMonthCode(){
        String str = (String)getSelectedItem();
        String[] el = str.split("-");
        return el[0];
    }

    public String getMonthName(){
        String str = (String)getSelectedItem();
        String[] el = str.split("-");
        return el[1];
    }


    public void setSelectedMonth(String code){
        int size = this.getItemCount();
        for(int i=0; i<=size-1; i++){
            String item = (String)this.getItemAt(i);
            if(item.startsWith(code)){
                setSelectedIndex(i);
                break;
            }
        }
    }
	
	

}
