package catalog.dao;

import catalog.model.CatalogItem;
import catalog.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;
//import java.util.Date;
//import java.util.Locale;
//import java.text.SimpleDateFormat;

/**
 * Returns the Database Access Object (DAO) for our CatalogItem class.
 */
public class CatalogItemDao {

    /*
     * Returns one CatalogItem object or null if not found
     */
    public static CatalogItem getByID(Integer id) {
        CatalogItem catalogitem = null;
        // Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // trans = session.beginTransaction();

            catalogitem = (CatalogItem) session.get(CatalogItem.class, id);

            // trans.commit();
        } catch (HibernateException e) {
            // if (trans != null) { trans.rollback(); }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return catalogitem;
    }

    /*
     * Adds a new CatalogItem object and return the id
     */
    public static int add(CatalogItem catalogitem) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        int id = 0;

        try {
            trans = session.beginTransaction();

            id = (int) session.save(catalogitem);

            trans.commit();
        } catch (HibernateException e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return id;
    }

    /*
     * Updates CatalogItem object
     */
    public static void update(CatalogItem catalogitem) {
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            session.update(catalogitem);

            trans.commit();
        } catch (HibernateException e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    /*
     * Deletes one CatalogItem record
     */
    public static boolean deleteByID(Integer id) {
        boolean deleted = false;
        Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            trans = session.beginTransaction();

            CatalogItem catalogitem = (CatalogItem) session.get(CatalogItem.class, id);

            if (catalogitem != null) {
                session.delete(catalogitem);
                trans.commit();
                deleted = true;
            }

        } catch (HibernateException e) {
            if (trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
            deleted = false;
        } finally {
            session.close();
        }
        return deleted;
    }

    /*
     * Returns a list of CatalogItem objects
     */
    public static List<CatalogItem> getAll() {
        List<CatalogItem> list = new ArrayList<CatalogItem>();
        // Transaction trans = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        try {
            // trans = session.beginTransaction();

            list = session.createQuery("from CatalogItem").list();

            // trans.commit();
        } catch (HibernateException e) {
            // if (trans != null) { trans.rollback(); }
            e.printStackTrace();
        } finally {
            // session.flush();
            session.close();
        }
        return list;
    }

}