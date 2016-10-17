package de.terrestris.momo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import de.terrestris.momo.model.tree.DocumentTreeFolder;
import de.terrestris.shogun2.model.Application;

/**
 *
 * @author Nils Bühner
 *
 */
@Entity
public class MomoApplication extends Application {

	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@ManyToMany
	@JoinTable(
		name = "MOMOAPPS_DOCROOTNODES",
		joinColumns = { @JoinColumn(name = "MOMOAPP_ID") },
		inverseJoinColumns = { @JoinColumn(name = "DOCROOTNODE_ID") }
	)
	@OrderColumn(name = "IDX")
	@JsonIdentityInfo(
			generator = ObjectIdGenerators.PropertyGenerator.class,
			property = "id"
			)
	@JsonIdentityReference(alwaysAsId = true)
	private List<DocumentTreeFolder> documentRootNodes = new ArrayList<DocumentTreeFolder>();

	/**
	 * 
	 */
	public MomoApplication() {
	}

	/**
	 * @return the documentRootNodes
	 */
	public List<DocumentTreeFolder> getDocumentRootNodes() {
		return documentRootNodes;
	}

	/**
	 * @param documentRootNodes the documentRootNodes to set
	 */
	public void setDocumentRootNodes(List<DocumentTreeFolder> documentRootNodes) {
		this.documentRootNodes = documentRootNodes;
	}


}
