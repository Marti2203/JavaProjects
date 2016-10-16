/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author marti
 */
import java.beans.*;
import magicbeans.DialListener;

public class DialBeanInfo extends SimpleBeanInfo {

    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        try {
            PropertyDescriptor value
                    = new PropertyDescriptor("value", Dial.class);
            PropertyDescriptor minimum
                    = new PropertyDescriptor("minimum", Dial.class);
            PropertyDescriptor maximum
                    = new PropertyDescriptor("maximum", Dial.class);
            return new PropertyDescriptor[]{value, minimum, maximum};
        } catch (IntrospectionException e) {
            return null;
        }
    }

    public EventSetDescriptor[] getEventSetDescriptors() {
        try {
            EventSetDescriptor dial = new EventSetDescriptor(
                    Dial.class,
                     "dialAdjusted",
                    DialListener.class,
                     "dialAdjusted");
            dial.setDisplayName("Dial Adjusted");
            return new EventSetDescriptor[]{dial};
        } catch (IntrospectionException e) {
            return null;
        }
    }
}
