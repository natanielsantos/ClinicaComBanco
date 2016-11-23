/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author nataniel
 */
@Entity
@Table(name = "cliente", catalog = "clinica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCli", query = "SELECT c FROM Cliente c WHERE c.idCli = :idCli"),
    @NamedQuery(name = "Cliente.findByNomeCli", query = "SELECT c FROM Cliente c WHERE c.nomeCli = :nomeCli"),
    @NamedQuery(name = "Cliente.findByRgCli", query = "SELECT c FROM Cliente c WHERE c.rgCli = :rgCli"),
    @NamedQuery(name = "Cliente.findByCpfCli", query = "SELECT c FROM Cliente c WHERE c.cpfCli = :cpfCli"),
    @NamedQuery(name = "Cliente.findBySexoCli", query = "SELECT c FROM Cliente c WHERE c.sexoCli = :sexoCli"),
    @NamedQuery(name = "Cliente.findByDtNascCli", query = "SELECT c FROM Cliente c WHERE c.dtNascCli = :dtNascCli"),
    @NamedQuery(name = "Cliente.findByLgrCli", query = "SELECT c FROM Cliente c WHERE c.lgrCli = :lgrCli"),
    @NamedQuery(name = "Cliente.findByNumCli", query = "SELECT c FROM Cliente c WHERE c.numCli = :numCli"),
    @NamedQuery(name = "Cliente.findByCidCli", query = "SELECT c FROM Cliente c WHERE c.cidCli = :cidCli"),
    @NamedQuery(name = "Cliente.findByEstCli", query = "SELECT c FROM Cliente c WHERE c.estCli = :estCli"),
    @NamedQuery(name = "Cliente.findByTel1Cli", query = "SELECT c FROM Cliente c WHERE c.tel1Cli = :tel1Cli"),
    @NamedQuery(name = "Cliente.findByTel2Cli", query = "SELECT c FROM Cliente c WHERE c.tel2Cli = :tel2Cli")})
public class Cliente implements Serializable {

    @OneToMany(mappedBy = "idCliente")
    private Collection<Animal> animalCollection;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cli")
    private Integer idCli;
    @Column(name = "nome_cli")
    private String nomeCli;
    @Column(name = "rg_cli")
    private String rgCli;
    @Column(name = "cpf_cli")
    private String cpfCli;
    @Column(name = "sexo_cli")
    private String sexoCli;
    @Column(name = "dt_nasc_cli")
    @Temporal(TemporalType.DATE)
    private Date dtNascCli;
    @Column(name = "lgr_cli")
    private String lgrCli;
    @Column(name = "num_cli")
    private String numCli;
    @Column(name = "cid_cli")
    private String cidCli;
    @Column(name = "est_cli")
    private String estCli;
    @Column(name = "tel1_cli")
    private String tel1Cli;
    @Column(name = "tel2_cli")
    private String tel2Cli;

    public Cliente() {
    }

    public Cliente(Integer idCli) {
        this.idCli = idCli;
    }

    public Integer getIdCli() {
        return idCli;
    }

    public void setIdCli(Integer idCli) {
        Integer oldIdCli = this.idCli;
        this.idCli = idCli;
        changeSupport.firePropertyChange("idCli", oldIdCli, idCli);
    }

    public String getNomeCli() {
        return nomeCli;
    }

    public void setNomeCli(String nomeCli) {
        String oldNomeCli = this.nomeCli;
        this.nomeCli = nomeCli;
        changeSupport.firePropertyChange("nomeCli", oldNomeCli, nomeCli);
    }

    public String getRgCli() {
        return rgCli;
    }

    public void setRgCli(String rgCli) {
        String oldRgCli = this.rgCli;
        this.rgCli = rgCli;
        changeSupport.firePropertyChange("rgCli", oldRgCli, rgCli);
    }

    public String getCpfCli() {
        return cpfCli;
    }

    public void setCpfCli(String cpfCli) {
        String oldCpfCli = this.cpfCli;
        this.cpfCli = cpfCli;
        changeSupport.firePropertyChange("cpfCli", oldCpfCli, cpfCli);
    }

    public String getSexoCli() {
        return sexoCli;
    }

    public void setSexoCli(String sexoCli) {
        String oldSexoCli = this.sexoCli;
        this.sexoCli = sexoCli;
        changeSupport.firePropertyChange("sexoCli", oldSexoCli, sexoCli);
    }

    public Date getDtNascCli() {
        return dtNascCli;
    }

    public void setDtNascCli(Date dtNascCli) {
        Date oldDtNascCli = this.dtNascCli;
        this.dtNascCli = dtNascCli;
        changeSupport.firePropertyChange("dtNascCli", oldDtNascCli, dtNascCli);
    }

    public String getLgrCli() {
        return lgrCli;
    }

    public void setLgrCli(String lgrCli) {
        String oldLgrCli = this.lgrCli;
        this.lgrCli = lgrCli;
        changeSupport.firePropertyChange("lgrCli", oldLgrCli, lgrCli);
    }

    public String getNumCli() {
        return numCli;
    }

    public void setNumCli(String numCli) {
        String oldNumCli = this.numCli;
        this.numCli = numCli;
        changeSupport.firePropertyChange("numCli", oldNumCli, numCli);
    }

    public String getCidCli() {
        return cidCli;
    }

    public void setCidCli(String cidCli) {
        String oldCidCli = this.cidCli;
        this.cidCli = cidCli;
        changeSupport.firePropertyChange("cidCli", oldCidCli, cidCli);
    }

    public String getEstCli() {
        return estCli;
    }

    public void setEstCli(String estCli) {
        String oldEstCli = this.estCli;
        this.estCli = estCli;
        changeSupport.firePropertyChange("estCli", oldEstCli, estCli);
    }

    public String getTel1Cli() {
        return tel1Cli;
    }

    public void setTel1Cli(String tel1Cli) {
        String oldTel1Cli = this.tel1Cli;
        this.tel1Cli = tel1Cli;
        changeSupport.firePropertyChange("tel1Cli", oldTel1Cli, tel1Cli);
    }

    public String getTel2Cli() {
        return tel2Cli;
    }

    public void setTel2Cli(String tel2Cli) {
        String oldTel2Cli = this.tel2Cli;
        this.tel2Cli = tel2Cli;
        changeSupport.firePropertyChange("tel2Cli", oldTel2Cli, tel2Cli);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCli != null ? idCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCli == null && other.idCli != null) || (this.idCli != null && !this.idCli.equals(other.idCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Cliente[ idCli=" + idCli + " ]";
    }
    
    /*@public Método para converter a data tipo String para date antes de armazenas no banco...*/
    public Date formataData(String data) throws Exception { 
		if (data == null || data.equals(""))
			return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date)formatter.parse(data);
        } catch (ParseException e) {            
            throw e;
        }
        return date;
	}

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @XmlTransient
    public Collection<Animal> getAnimalCollection() {
        return animalCollection;
    }

    public void setAnimalCollection(Collection<Animal> animalCollection) {
        this.animalCollection = animalCollection;
    }
    
}
