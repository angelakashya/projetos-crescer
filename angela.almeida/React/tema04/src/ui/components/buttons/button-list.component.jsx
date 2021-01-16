import React from 'react'
import Pagination from '@material-ui/lab/Pagination'
import PaginationItem from '@material-ui/lab/PaginationItem'
import { Link } from 'react-router-dom'
import { useParams } from 'react-router-dom'
import './style.css'

export function CustomPagination(numPaginas) {
    const { paginaId } = useParams()
    return (
        <div className="pagination">
            <Pagination
                page={parseInt(paginaId)}
                count={numPaginas.value}
                variant="outlined"
                shape="rounded"
                renderItem={(item) => (
                    <PaginationItem
                        component={Link}
                        to={`/lista/pagina/${item.page}`}
                        {...item}
                    />
                )}
            />
        </div>
    )
}