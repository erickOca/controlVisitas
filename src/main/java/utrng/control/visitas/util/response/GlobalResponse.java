package utrng.control.visitas.util.response;

public class GlobalResponse {
    long alumnos;
    long personal;
    long externos;
    long totalVisitas;

    public GlobalResponse() {
    }

    public GlobalResponse(long alumnos, long personal, long externos, long totalVisitas) {
        this.alumnos = alumnos;
        this.personal = personal;
        this.externos = externos;
        this.totalVisitas = totalVisitas;
    }

    public long getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(long alumnos) {
        this.alumnos = alumnos;
    }

    public long getPersonal() {
        return personal;
    }

    public void setPersonal(long personal) {
        this.personal = personal;
    }

    public long getExternos() {
        return externos;
    }

    public void setExternos(long externos) {
        this.externos = externos;
    }

    public long getTotalVisitas() {
        return totalVisitas;
    }

    public void setTotalVisitas(long totalVisitas) {
        this.totalVisitas = totalVisitas;
    }
}
