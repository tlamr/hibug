package hibug;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.OrderColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;

@Entity
public class Hentity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ElementCollection
	@OrderColumn(name="nextRevUN_index")
	private List<String> nextRevUNs;

	@OneToMany(fetch= FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "clicId")
	@OrderBy("id asc")
	protected List<HotherEntity> lineItems;

	@Basic
	private Long number;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(value = TemporalType.TIMESTAMP)
	private Date deleteDate;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public List<String> getNextRevUNs() {
		return nextRevUNs;
	}

	public void setNextRevUNs(List<String> nextRevUNs) {
		this.nextRevUNs = nextRevUNs;
	}

	public List<HotherEntity> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<HotherEntity> lineItems) {
		this.lineItems = lineItems;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public void bumpNumber() {
		number = number == null ? 0 : number++;
	}
}
