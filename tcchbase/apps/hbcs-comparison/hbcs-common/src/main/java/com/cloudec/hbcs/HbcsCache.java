package com.cloudec.hbcs;

import static org.fusesource.leveldbjni.JniDBFactory.bytes;
import static org.fusesource.leveldbjni.JniDBFactory.factory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;

/**
 * @author SOUZA JR, JOAO
 * @since 2017-03-24
 */
public class HbcsCache {

  private String pathDb;

  public HbcsCache() {
    this.pathDb = "hbcscache";
  }

  public HbcsCache(String pathDb) {
    this.pathDb = pathDb;
  }

  public void put(String key, Map<String, String> data) {
    Options options = new Options();
    options.createIfMissing(true);
    DB db = null;
    try {
      db = factory.open(HbcsFileUtils.tempFile(pathDb), options);
      ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
      ObjectOutputStream out = new ObjectOutputStream(byteOut);
      out.writeObject(data);
      db.put(bytes(key), byteOut.toByteArray());
    } catch (Exception ex) {
      throw new HbcsException("HbcsCache.put", ex);
    } finally {
      closeDb(db);
    }
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> get(String key) {
    Options options = new Options();
    options.createIfMissing(true);
    DB db = null;
    Map<String, String> data = new HashMap<>();
    try {
      db = factory.open(HbcsFileUtils.tempFile(pathDb), options);
      byte[] dataBytes = db.get(bytes(key));
      // Parse byte array to Map
      if (dataBytes != null) {
        ByteArrayInputStream byteIn = new ByteArrayInputStream(dataBytes);
        ObjectInputStream in = new ObjectInputStream(byteIn);
        data = (Map<String, String>) in.readObject();
      } else {
        data = Collections.emptyMap();
      }
    } catch (Exception ex) {
      throw new HbcsException("HbcsCache.get", ex);
    } finally {
      closeDb(db);
    }
    return data;
  }

  private void closeDb(final DB db) {
    try {
      if (db != null) {
        db.close();
      }
    } catch (IOException ex) {
      throw new HbcsException("HbcsCache.close", ex);
    }
  }

  public void destroy() {
    try {
      Options options = new Options();
      factory.destroy(HbcsFileUtils.tempFile(pathDb), options);
    } catch (IOException ex) {
      throw new HbcsException("HbcsCache.destroy", ex);
    }
  }
}
