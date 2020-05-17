# Jobs Search Reporter

Un pequeño CLI para buscar trabajo con Github. Proyecto realizado en el curso de Programación Funcional en Java de Platzi.

---

## Descripcion

utiliza [la API de Github](https://jobs.github.com/) para buscar empleos.
Funciona a partir algunos opciones/parametros de busqueda.

La manera de invocar el CLI es:

```
jobs-search [OPTIONS] <SKILL>
```

Donde `[OPTIONS]` son:
 
```
--location <UBICACION>  # <UBICACION>: Algun lugar del mundo, tambien disponible como: -l
--page <PAGINA>         # <PAGINA>: Los resultados se muestran de 50 en 50, cada 50 resultados se le conoce como pagina empezando en 0. Default: 0. Tambien disponible como: -p
--full-time             # Si queremos que sean solo empleos de tiempo completo. default: false
--markdown              # Mostrar los resultados en Markdown
```

Y `<SKILL>` es el tipo de skill del que queremos encontrar trabajos.

### Ejemplo

Para buscar trabajos de `Java` en Tokyo, usariamos:

`jobs-search --location tokyo java` 
