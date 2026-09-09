# Framework para Desenvolvimento de Software

Projetos das aulas práticas — Faculdade Anhanguera de São Gonçalo (ADS / EAD)

Aluno: Marcelo Silvestre Leite  
Matrícula: 2025173333

## Rodar a calculadora agora (sem instalar nada)

Abra este arquivo no navegador:

- No repositório: pasta `docs/index.html` → botão **Raw** não serve; use o preview:
- Preview direto: https://htmlpreview.github.io/?https://github.com/MarceloSilvestreleite/framework-desenvolvimento-software-aulas/blob/main/docs/index.html
- Ou baixe o ZIP do repositório, abra a pasta `docs` e dê dois cliques em `index.html`

Depois que o GitHub Pages publicar (Settings → Pages), o link fixo fica:
https://marcelosilvestreleite.github.io/framework-desenvolvimento-software-aulas/

Mesmas regras da aula Flask: INSS 8%, IR 15% se bruto &gt; 2500, R$ 200 por dependente.

## Pastas

| Pasta | Aula | O que faz |
|---|---|---|
| `docs/` | versão para abrir no navegador | Calculadora pronta |
| `calculadora_salario_flask/` | U4 A4 — Framework Python | Código Flask da entrega |
| `cadastro_produtos_android/` | U3 A4 — Frameworks mobile | App Android + SQLite |

## Flask na máquina (entrega da faculdade)

```bash
cd calculadora_salario_flask
python -m venv venv
venv\Scripts\activate
pip install -r requirements.txt
python app.py
```

Abra http://127.0.0.1:5000
