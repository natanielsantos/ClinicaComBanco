/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "animal")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Animal.findAll", query = "SELECT a FROM Animal a"),
    @NamedQuery(name = "Animal.findByIdAnimal", query = "SELECT a FROM Animal a WHERE a.idAnimal = :idAnimal"),
    @NamedQuery(name = "Animal.findByNomeAnimal", query = "SELECT a FROM Animal a WHERE a.nomeAnimal = :nomeAnimal"),
    @NamedQuery(name = "Animal.findByDataNascimento", query = "SELECT a FROM Animal a WHERE a.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Animal.findByPeso", query = "SELECT a FROM Animal a WHERE a.peso = :peso"),
    @NamedQuery(name = "Animal.findByCorPelagem", query = "SELECT a FROM Animal a WHERE a.corPelagem = :corPelagem"),
    @NamedQuery(name = "Animal.findByEspecie", query = "SELECT a FROM Animal a WHERE a.especie = :especie"),
    @NamedQuery(name = "Animal.findByRaca", query = "SELECT a FROM Animal a WHERE a.raca = :raca"),
    @NamedQuery(name = "Animal.findBySexo", query = "SELECT a FROM Animal a WHERE a.sexo = :sexo"),
    @NamedQuery(name = "Animal.findByObs", query = "SELECT a FROM Animal a WHERE a.obs = :obs")})
public class Animal implements Serializable {

    @OneToMany(mappedBy = "idAnimal")
    private Collection<Consulta> consultaCollection;

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_animal")
    private Integer idAnimal;
    @Column(name = "nome_animal")
    private String nomeAnimal;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "peso")
    private Double peso;
    @Column(name = "cor_pelagem")
    private String corPelagem;
    @Column(name = "especie")
    private String especie;
    @Column(name = "raca")
    private String raca;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "obs")
    private String obs;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cli")
    @ManyToOne
    private Cliente idCliente;

    public Animal() {
    }

    public Animal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        Integer oldIdAnimal = this.idAnimal;
        this.idAnimal = idAnimal;
        changeSupport.firePropertyChange("idAnimal", oldIdAnimal, idAnimal);
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        String oldNomeAnimal = this.nomeAnimal;
        this.nomeAnimal = nomeAnimal;
        changeSupport.firePropertyChange("nomeAnimal", oldNomeAnimal, nomeAnimal);
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        Date oldDataNascimento = this.dataNascimento;
        this.dataNascimento = dataNascimento;
        changeSupport.firePropertyChange("dataNascimento", oldDataNascimento, dataNascimento);
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        Double oldPeso = this.peso;
        this.peso = peso;
        changeSupport.firePropertyChange("peso", oldPeso, peso);
    }

    public String getCorPelagem() {
        return corPelagem;
    }

    public void setCorPelagem(String corPelagem) {
        String oldCorPelagem = this.corPelagem;
        this.corPelagem = corPelagem;
        changeSupport.firePropertyChange("corPelagem", oldCorPelagem, corPelagem);
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        String oldEspecie = this.especie;
        this.especie = especie;
        changeSupport.firePropertyChange("especie", oldEspecie, especie);
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        String oldRaca = this.raca;
        this.raca = raca;
        changeSupport.firePropertyChange("raca", oldRaca, raca);
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        String oldSexo = this.sexo;
        this.sexo = sexo;
        changeSupport.firePropertyChange("sexo", oldSexo, sexo);
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        String oldObs = this.obs;
        this.obs = obs;
        changeSupport.firePropertyChange("obs", oldObs, obs);
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        Cliente oldIdCliente = this.idCliente;
        this.idCliente = idCliente;
        changeSupport.firePropertyChange("idCliente", oldIdCliente, idCliente);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAnimal != null ? idAnimal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Animal)) {
            return false;
        }
        Animal other = (Animal) object;
        if ((this.idAnimal == null && other.idAnimal != null) || (this.idAnimal != null && !this.idAnimal.equals(other.idAnimal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Animal[ idAnimal=" + idAnimal + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

    @XmlTransient
    public Collection<Consulta> getConsultaCollection() {
        return consultaCollection;
    }

    public void setConsultaCollection(Collection<Consulta> consultaCollection) {
        this.consultaCollection = consultaCollection;
    }
    
}
