package de.dsg.foglight.rest.data;

import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: stefan
 * Date: 12.06.13
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */

@XmlRootElement(name = "StatusData")
public class StatusData {
    private final int _code;
    private final String _description;
    private final String _shortStatus;

    public StatusData() {
        this(-1,"none","");
    }
    public StatusData(int i, String shortMessage, String longMessage) {
        _code = i;
        _shortStatus = shortMessage;
        _description = longMessage;


    }

    @XmlAttribute
    public int get_code() {
        return _code;
    }
    @XmlElement
    public String get_description() {
        return _description;
    }
    @XmlAttribute
    public String get_shortStatus() {
        return _shortStatus;
    }
}
