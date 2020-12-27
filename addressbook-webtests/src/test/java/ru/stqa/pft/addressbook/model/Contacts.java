package ru.stqa.pft.addressbook.model;
import com.google.common.collect.ForwardingSet;
import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<DataContact> {

  private Set<DataContact> delegate;


  public Contacts(Contacts contacts) {
    this.delegate = new HashSet<DataContact>(contacts.delegate);
  }
  public Contacts() {
    this.delegate = new HashSet<DataContact>();
  }


  @Override
  protected Set<DataContact> delegate() {
    return delegate;
  }

  public Contacts withAdded(DataContact contact) {
    Contacts contacts = new Contacts(this);
    contacts.add(contact);
    return contacts;
  }

  public Contacts without(DataContact contact) {
    Contacts contacts = new Contacts(this);
    contacts.remove(contact);
    return contacts;
  }

}
