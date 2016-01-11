/**
 * This work is Open Source and licensed by the European Commission under the
 * conditions of the European Public License v1.1 
 *  
 * (http://www.osor.eu/eupl/european-union-public-licence-eupl-v.1.1); 
 * 
 * any use of this file implies acceptance of the conditions of this license. 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS,  WITHOUT 
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the 
 * License for the specific language governing permissions and limitations 
 * under the License.
 */
package eu.eidas.auth.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.joda.time.DateTime;

/**
 * This class is a bean used to store the information relative to the
 * EIDASAuthnResponse.
 *
 */
public final class EIDASAuthnResponse {

    /**
     * Response Id.
     */
    private String samlId;

    /**
     * Authentication failed?
     */
    private boolean fail;

    /**
     * Status code.
     */
    private String statusCode;

    /**
     * Secondary status code.
     */
    private String subStatusCode;

    /**
     * Audience restriction.
     */
    private transient String audienceRest;

    /**
     * Error message.
     */
    private String message;

    /**
     * Id of the request that originated this response.
     */
    private String inResponseTo;

    /**
     * Expiration date.
     */
    private DateTime notOnOrAfter;

    /**
     * Creation date.
     */
    private DateTime notBefore;

    /**
     * The SAML token.
     */
    private byte[] tokenSaml = new byte[0];

    /**
     * Country.
     */
    private String country;

    private boolean encrypted;

    /**
     * Citizen's personal attribute list.
     */
    private transient IPersonalAttributeList attributeList = new PersonalAttributeList();

    /** The issuer. */
    private String issuer;

    /**
     * LoA for the response
     */
    private String assuranceLevel;

    /**
     * Logger object.
     */
    private static final Logger LOG = LoggerFactory.getLogger(EIDASAuthnResponse.class.getName());

    /**
     * Getter for the subStatusCode.
     *
     * @return The subStatusCode value.
     */
    public String getSubStatusCode() {
        return subStatusCode;
    }

    /**
     * Setter for the subStatusCode.
     *
     * @param samlSubStatusCode the new subStatusCode value.
     */
    public void setSubStatusCode(final String samlSubStatusCode) {
        this.subStatusCode = samlSubStatusCode;
    }

    /**
     * Getter for audienceRest.
     *
     * @return The audienceRest value.
     */
    public String getAudienceRestriction() {
        return audienceRest;
    }

    /**
     * Setter for audienceRest.
     *
     * @param audRest the new audienceRest value.
     */
    public void setAudienceRestriction(final String audRest) {
        this.audienceRest = audRest;
    }

    /**
     * Getter for the samlToken.
     *
     * @return The samlToken value.
     */
    public byte[] getTokenSaml() {
        return tokenSaml.clone();
    }

    /**
     * Setter for samlToken.
     *
     * @param samlToken the new tokenSaml value.
     */
    public void setTokenSaml(final byte[] samlToken) {
        if (samlToken != null) {
            this.tokenSaml = samlToken.clone();
        }
    }

    /**
     * Getter for the country name.
     *
     * @return The country name value.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter for the country name.
     *
     * @param cCountry the new country name value.
     */
    public void setCountry(final String cCountry) {
        this.country = cCountry;
    }

    /**
     * Getter for pal value.
     *
     * @return The pal value.
     * @see PersonalAttributeList
     */
    public IPersonalAttributeList getPersonalAttributeList() {
        IPersonalAttributeList personnalAttributeList = null;
        try {
            personnalAttributeList = (IPersonalAttributeList) attributeList.clone();
        } catch (CloneNotSupportedException e1) {
            LOG.trace("[PersonalAttribute] Nothing to do. {}", e1);
        }
        return personnalAttributeList;
    }

    /**
     * Setter for the Personal Attribute List value.
     *
     * @param attrList the new value.
     * @see PersonalAttributeList
     */
    public void setPersonalAttributeList(final IPersonalAttributeList attrList) {
        if (attrList != null) {
            this.attributeList = attrList;
        }
    }

    /**
     * Getter for the inResponseTo value.
     *
     * @return The inResponseTo value.
     */
    public String getInResponseTo() {
        return inResponseTo;
    }

    /**
     * Setter for the inResponseTo value.
     *
     * @param samlInResponseTo the new inResponseTo value.
     */
    public void setInResponseTo(final String samlInResponseTo) {
        this.inResponseTo = samlInResponseTo;
    }

    /**
     * Getter for the fail value.
     *
     * @return The fail value.
     */
    public boolean isFail() {
        return fail;
    }

    /**
     * Setter for the fail value.
     *
     * @param failVal the new fail value.
     */
    public void setFail(final boolean failVal) {
        this.fail = failVal;
    }

    /**
     * Getter for the message value.
     *
     * @return The message value.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Setter for the message value.
     *
     * @param msg the new message value.
     */
    public void setMessage(final String msg) {
        this.message = msg;
    }

    /**
     * Getter for the statusCode value.
     *
     * @return The statusCode value.
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Setter for the statusCode value.
     *
     * @param status the new statusCode value.
     */
    public void setStatusCode(final String status) {
        this.statusCode = status;
    }

    /**
     * Getter for the samlId value.
     *
     * @return The samlId value.
     */
    public String getSamlId() {
        return samlId;
    }

    /**
     * Setter for the samlId value.
     *
     * @param nSamlId the new samlId value.
     */
    public void setSamlId(final String nSamlId) {
        this.samlId = nSamlId;
    }

    /**
     * Getter for the notOnOrAfter value.
     *
     * @return The notOnOrAfter value.
     * @see DateTime
     */
    public DateTime getNotOnOrAfter() {
        return this.notOnOrAfter;
    }

    /**
     * Setter for the notOnOrAfter value.
     *
     * @param nOnOrAfter the new notOnOrAfter value.
     * @see DateTime
     */
    public void setNotOnOrAfter(final DateTime nOnOrAfter) {
        this.notOnOrAfter = nOnOrAfter;
    }

    /**
     * Getter for the notBefore value.
     *
     * @return The notBefore value.
     * @see DateTime
     */
    public DateTime getNotBefore() {
        return notBefore;
    }

    /**
     * Setter for the notBefore value.
     *
     * @param nBefore the new notBefore value.
     * @see DateTime
     */
    public void setNotBefore(final DateTime nBefore) {
        this.notBefore = nBefore;
    }

    public String getAssuranceLevel() {
        return assuranceLevel;
    }

    public void setAssuranceLevel(String assuranceLevelArg) {
        this.assuranceLevel = assuranceLevelArg;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName()).append(" [")
                .append("samlId             ").append(samlId).append(",\n")
                .append("fail               ").append(fail).append(",\n")
                .append("statusCode         ").append(statusCode).append(",\n")
                .append("subStatusCode      ").append(subStatusCode).append(",\n")
                .append("audienceRest       ").append(audienceRest).append(",\n")
                .append("message            ").append(message).append(",\n")
                .append("inResponseTo       ").append(inResponseTo).append(",\n")
                .append("notOnOrAfter       ").append(notOnOrAfter).append(",\n")
                .append("notBefore          ").append(notBefore).append(",\n")
                .append("country            ").append(country).append(",\n")
                .append("issuer             ").append(issuer).append(",\n")
                .append("]");
        return stringBuilder.toString();
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuerArg) {
        this.issuer = issuerArg;
    }

    public boolean isEncrypted() {
        return encrypted;
    }

    public void setEncrypted(boolean encryptedArg) {
        this.encrypted = encryptedArg;
    }
}
