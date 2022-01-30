package models;

/*
CREATE TABLE health_inspector(
inspector_id SERIAL PRIMARY KEY,
inspector_name (varchar)(50) NOT NULL,
inspector_username (varchar)(50) NOT NULL,
inspector_password (varchar)(50) NOT NULL
);
 */

public class HealthInspector {
    //These are the variables fields for HealthInspector.
    private Integer inspectorId;
    private String inspectorName;
    private String inspectorUserName;
    private String inspectorPassword;

    public HealthInspector() {
    }
    //These are my constructors.
    public HealthInspector(Integer inspectorId, String inspectorName, String inspectorUserName, String inspectorPassword) {
        this.inspectorId = inspectorId;
        this.inspectorName = inspectorName;
        this.inspectorUserName = inspectorUserName;
        this.inspectorPassword = inspectorPassword;
    }

    public Integer getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(Integer inspectorId) {
        this.inspectorId = inspectorId;
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName;
    }

    public String getInspectorUserName() {
        return inspectorUserName;
    }

    public void setInspectorUserName(String inspectorUserName) {
        this.inspectorUserName = inspectorUserName;
    }

    public String getInspectorPassword() {
        return inspectorPassword;
    }

    public void setInspectorPassword(String inspectorPassword) {
        this.inspectorPassword = inspectorPassword;
    }

    @Override
    public String toString() {
        return "HealthInspector{" +
                "inspectorId=" + inspectorId +
                ", inspectorName='" + inspectorName + '\'' +
                /*", inspectorUserName='" + inspectorUserName + '\'' +
                ", inspectorPassword='" + inspectorPassword + '\'' +*/
                '}' +'\n';
    }
}
