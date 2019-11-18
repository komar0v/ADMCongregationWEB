/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelasJava;

import com.mysql.jdbc.Blob;


/**
 *
 * @author ASUS
 */
public class biodata_suster {

    public String id_Suster;
    private String nama_suster, nama_asal_suster, tempat_lahir_suster, tanggal_lahir_suster, nama_ayah_suster, nama_ibu_suster;
    private int anak_ke, jmlh_saudara;
    private Blob foto_suster;

    /**
     * @return the nama_suster
     */
    public String getNama_suster() {
        return nama_suster;
    }

    /**
     * @param nama_suster the nama_suster to set
     */
    public void setNama_suster(String nama_suster) {
        this.nama_suster = nama_suster;
    }

    /**
     * @return the nama_asal_suster
     */
    public String getNama_asal_suster() {
        return nama_asal_suster;
    }

    /**
     * @param nama_asal_suster the nama_asal_suster to set
     */
    public void setNama_asal_suster(String nama_asal_suster) {
        this.nama_asal_suster = nama_asal_suster;
    }

    /**
     * @return the tempat_lahir_suster
     */
    public String getTempat_lahir_suster() {
        return tempat_lahir_suster;
    }

    /**
     * @param tempat_lahir_suster the tempat_lahir_suster to set
     */
    public void setTempat_lahir_suster(String tempat_lahir_suster) {
        this.tempat_lahir_suster = tempat_lahir_suster;
    }

    /**
     * @return the tanggal_lahir_suster
     */
    public String getTanggal_lahir_suster() {
        return tanggal_lahir_suster;
    }

    /**
     * @param tanggal_lahir_suster the tanggal_lahir_suster to set
     */
    public void setTanggal_lahir_suster(String tanggal_lahir_suster) {
        this.tanggal_lahir_suster = tanggal_lahir_suster;
    }

    /**
     * @return the nama_ayah_suster
     */
    public String getNama_ayah_suster() {
        return nama_ayah_suster;
    }

    /**
     * @param nama_ayah_suster the nama_ayah_suster to set
     */
    public void setNama_ayah_suster(String nama_ayah_suster) {
        this.nama_ayah_suster = nama_ayah_suster;
    }

    /**
     * @return the nama_ibu_suster
     */
    public String getNama_ibu_suster() {
        return nama_ibu_suster;
    }

    /**
     * @param nama_ibu_suster the nama_ibu_suster to set
     */
    public void setNama_ibu_suster(String nama_ibu_suster) {
        this.nama_ibu_suster = nama_ibu_suster;
    }

    /**
     * @return the id_Suster
     */
    public String getId_Suster() {
        return id_Suster;
    }

    /**
     * @param id_Suster the id_Suster to set
     */
    public void setId_Suster(String id_Suster) {
        this.id_Suster = id_Suster;
    }

    /**
     * @return the anak_ke
     */
    public int getAnak_ke() {
        return anak_ke;
    }

    /**
     * @param anak_ke the anak_ke to set
     */
    public void setAnak_ke(int anak_ke) {
        this.anak_ke = anak_ke;
    }

    /**
     * @return the jmlh_saudara
     */
    public int getJmlh_saudara() {
        return jmlh_saudara;
    }

    /**
     * @param jmlh_saudara the jmlh_saudara to set
     */
    public void setJmlh_saudara(int jmlh_saudara) {
        this.jmlh_saudara = jmlh_saudara;
    }

    /**
     * @return the foto_suster
     */
    public Blob getFoto_suster() {
        return foto_suster;
    }

    /**
     * @param foto_suster the foto_suster to set
     */
    public void setFoto_suster(Blob foto_suster) {
        this.foto_suster = foto_suster;
    }
}
