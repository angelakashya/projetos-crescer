import React, { useState, useEffect } from 'react'
import { ApiCurtida } from '../../../hooks/postagens/ApiCurtida'
import { ApiPostagem } from '../../../hooks/postagens/ApiPostagem'
import { ApiComentario } from '../../../hooks/postagens/ApiComentario'
import { ApiDadosUsuario } from '../../../hooks/usuario/ApiDadosUsuario'
import { Input } from '../../components/input/input.component'

import "./style.css"
import { ApiRegistroUsuario } from '../../../hooks/usuario/ApiRegistroUsuario'
import { ApiAmigo } from '../../../hooks/postagens/ApiAmigo'

export function Dashboard() {
    const [texto, setTexto] = useState("")
    const [comentarioTexto, setCometario] = useState({})
    const [imagem, setImagem] = useState("")
    const [error, setError] = useState()
    const [postagens, setPostagens] = useState([])
    const [acao, setACao] = useState([])
    const [acaoAmizade, setAcaoAmizade] = useState([])
    const [naoAmigo, setNaoAmigo] = useState([])
    const [solicitacoes, setSolicitacoes] = useState([])

    const usuario = JSON.parse(localStorage.getItem("user"))

    useEffect(() => {
        async function obterPostagens() {
            const response = await ApiPostagem().obterPostagens()
            let result = response.data;

            for (let post of result) {
                post.curtida = (await ApiCurtida().countByPost(post.id)).data
                post.comentario = (await ApiComentario().obterComentarios(post.id)).data
            }
            setPostagens(result)
        }

        obterPostagens()
    }, [acao])

    useEffect(() => {
        async function obterNaoAmigos() {
            const response = await ApiDadosUsuario().listarNaoAmigo(usuario.id)
            console.log(response.data);
            setNaoAmigo(response.data)
        }

        async function obterSolicitacoes() {
            const response = await ApiDadosUsuario().listarSolicitacoes(usuario.id)
            setSolicitacoes(response.data)
        }

        obterNaoAmigos()
        obterSolicitacoes()
    }, [acaoAmizade])


    async function handleSubmitPostagem(event) {
        event.preventDefault()

        try {
            const postagem = {
                texto,
                imagem,
                idUsuario: {
                    id: usuario.id
                }
            }

            await ApiPostagem().registrarPostagem(postagem)
            setACao([])
        } catch (error) {
            setError("Algo de errado aconteceu")
        }
    }

    async function handleSubmitComentario(postagem) {
        try {
            const comentario = {
                texto: comentarioTexto,
                imagem: 'imagem',
                idUsuario: {
                    id: usuario.id
                },
                idPostagem: {
                    id: postagem.id
                }
            }

            await ApiComentario().registrarComentario(comentario)

        } catch (error) {
            setError("Algo de errado aconteceu")
        }
    }

    async function curtir(postagem) {
        await ApiCurtida().curtir({ idPostagem: postagem, idUsuario: { id: usuario.id } });
        setACao([])
    }

    async function socilitarAmizade(idAmigo) {
        const amigo = {
            idAmigo: {
                id: idAmigo.id
            },
            idUsuario: {
                id: usuario.id
            },
            aceito: true
        }

        await ApiAmigo().solicitarAmizade(amigo);
        setAcaoAmizade([])
    }
    async function atualizarAmizade(idAmigo, aceito) {
        const amigo = {
            idAmigo: {
                id: idAmigo.idUsuario.id
            },
            idUsuario: {
                id: usuario.id
            },
            aceito: true
        }

        await ApiAmigo().solicitarAmizade(amigo);
        setAcaoAmizade([])
    }

    return (
        <div className="dash-container row">
            <div className="profile-column col-3">
                <img className="profile-img" src={usuario.imagem} alt="Imagem de perfil"></img>
                <h3>{usuario.nomeCompleto}</h3>
                <img className="heart" src="https://cdn0.iconfinder.com/data/icons/small-n-flat/24/678087-heart-512.png" alt="coração"></img>
                <img className="skate" src="https://img.icons8.com/ios/452/skateboard.png" alt="skate"></img>
                <div className="profile-info">

                </div>
            </div>

            <div className="post-column col-6">
                <div className="post-title">
                    <h3>Compartilhe algo com seus amigos!</h3>
                    <form onSubmit={handleSubmitPostagem}>
                        <Input
                            handleChange={setTexto}
                            value={texto}
                        />
                        <Input
                            type="text"
                            name="imagem"
                            label="Link da Imagem"
                            handleChange={setImagem}
                            value={imagem}
                            required />
                        <button className="btn-post">Postar</button>
                    </form>
                    <hr></hr>
                </div>
                <div className="lista">
                    <ul>
                        {(postagens).map((p, index) => {
                            return <li key={index}>
                                {p.texto}
                                <img className="imgPost" src={p.imagem}></img>
                                <button className="btn-like" onClick={() => curtir(p)}>Curtir ({p.curtida})</button>
                                <form onSubmit={() => handleSubmitComentario(p)}>
                                    <Input
                                        type="text"
                                        name="comentario"
                                        label="Deixe seu comentário"
                                        handleChange={e => setCometario(e)}
                                        required />
                                    <button className="btn-post">Enviar comentário</button>
                                    <div className='comentarios'>
                                        <ul>
                                            {(p.comentario || []).map((c, index) => {
                                                return <li key={`comentario${c.id}`}>
                                                    {c.texto}
                                                </li>
                                            })}
                                        </ul>
                                    </div>
                                </form>
                            </li>
                        })}
                    </ul>
                </div>
            </div>

            <div className="friends-column col-3">
                <h5>Descubra novos amigos</h5>
                <ul>
                    {naoAmigo.map((n, index) => {
                        return <li key={`$naoAmigo${n.id}`}>
                            <img src={n.imagemPerfil} alt=""></img>
                            <span> {n.nomeCompleto} </span>
                            <br></br>
                            <button className="btn-friend" onClick={() => socilitarAmizade(n)}>Solcitar amizade</button>
                        </li>
                    })}
                </ul>
                <hr></hr>
                <h5>Suas solicitações de Amizade</h5>
                <ul>
                    {solicitacoes.map((s, index) => {
                        return <li key={`$solicitacoes${s.id}`}>
                            <img src={s.idUsuario.imagemPerfil} alt="" />
                            <span> {s.idUsuario.nomeCompleto} </span>
                            <br></br>
                            <button className="btn-friend" onClick={() => atualizarAmizade(s, true)}>Aceitar amizade</button>
                        </li>
                    })}
                </ul>
            </div>
        </div>
    )
}