package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.DataContact;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main (String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);

    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }

    generator.run();
  }

  private void run() throws IOException {
    List<DataContact> contacts = generateContacts(count);

    save(contacts, new File(file));
  }

  private void save(List<DataContact> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);

    try (Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private List<DataContact> generateContacts(int count) {
    List<DataContact> contacts = new ArrayList<DataContact>();

    for (int i = 0; i < count; i++) {
      contacts.add(new DataContact()
              .withFirstname(String.format("Ivan %s", i))
              .withLastname(String.format("Petrov %s", i))
              .withContact("test")
              .withHomePhone("557868686")
              .withMobilePhone("938374664")
              .withWorkPhone("383664664")
              .withEmail("test@test.ru")
              .withEmail2("test2@test.ru")
              .withEmail3("test3@test.ru")
              .withAddress("Tver")
              .withAddress2("r")
      );
    }

    return contacts;
  }
}
