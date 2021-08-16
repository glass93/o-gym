import styled from 'styled-components';
import { FacebookFilled, GoogleCircleFilled } from '@ant-design/icons';

export interface ButtonPropsType {
    backgroundColor?: string;
    onClick?: Function;
    width: string;
    margin: string;
    signInType: "facebook" | "google" | "naver" | undefined;
    border?: string;
    height?: string;
    padding?: string;
    borderRadius?: string;
    color?: string;
}

const StyledButton = styled.button<ButtonPropsType>`
    background: ${props => props.backgroundColor || "white"};
    width: ${props => props.width || "auto"};
    padding: ${props => props.padding || "10px"};
    margin: ${props => props.margin || ""};
    border: ${props => props.border || "none"};
    height: ${props => props.height};
    border-radius: ${props => props.borderRadius};
    color: ${props => props.color || "black"};
    cursor: pointer;
`;

const NaverIcon = () : JSX.Element => {
    return (
        <svg enable-background="new 0 0 512 512"
            height="20px" id="Layer_1"
            version="1.1"
            viewBox="0 0 512 512"
            width="20px"
        ><g><circle cx="255.999" cy="256" r="246.455" /></g><g><path d="M55.486,231.011h28.315c0,0,25.719,38.858,26.483,39.905c0.769,1.041,0.861,0,0.861,0   c-1.184-6.02-2.473-8.717-2.473-18.328v-21.577h28.205v71.977h-28.205c0,0-25.189-36.781-25.952-37.801   c-0.759-1.018-0.862,0-0.862,0c0.971,4.969,1.832,5.795,1.832,14.416v23.385H55.484L55.486,231.011L55.486,231.011z" fill="#FFFFFF" /><path d="M181.342,276.93l3.85-14.607c0.829-2.959,1.4-7.21,1.4-7.21c0.122-0.653,1.025-0.653,1.18,0.032   c0.185,1.002,0.635,4.063,1.496,7.114l3.924,14.672H181.342z M176.064,294.018h22.299l2.688,8.969h31.222l-28.962-71.975h-32.623   l-28.211,71.977h31.228L176.064,294.018z" fill="#FFFFFF" /><path d="M306.575,231.011l-31.436,71.977h-24.981l-31.438-71.977h30.792l10.769,32.743   c1.184,3.531,2.044,11.287,2.044,11.287c0.203,0.611,0.924,0.57,1.041,0c0,0,0.861-7.756,2.048-11.287l10.368-32.743H306.575z" fill="#FFFFFF" /><path d="M312.71,231.011h54.595v19.669H342.43v6.869h22.721v18.709H342.43v7.066h25.733v19.664H312.71V231.011   L312.71,231.011z" fill="#FFFFFF" /><path d="M409.026,250.68h2.267c5.059,0,9.47,0.661,9.47,6.202c0,5.342-4.845,6.015-9.692,6.015h-2.044V250.68z    M380.175,302.992h28.851v-23.106c0,0,0.188-0.82,0.738,0l12.725,23.104h34.027l-17.662-23.393c-1.62-2.096-4.344-3.895-4.953-4.29   c-0.607-0.405,0-0.581,0-0.581c10.979-3.244,15.72-7.821,15.72-18.708c0-18.136-15.509-25.01-33.81-25.01h-35.636V302.992   L380.175,302.992z" fill="#FFFFFF" /></g></svg>
    );
}

const Button = (props: any): JSX.Element => {
    
    return (
        <>
            <StyledButton backgroundColor={props.backgroundColor}
                width={props.width}
                onClick={props.onClick}
                signInType={props.signInType}
                margin={props.margin}
                border={props.border}
                height={props.height}
                padding={props.padding}
                borderRadius={props.borderRadius}
                color={props.color}
            >
                {props.signInType === "facebook" ?
                    <FacebookFilled /> : ''}
                {props.signInType === "google" ?
                    <GoogleCircleFilled /> : ''}
                {props.signInType === "naver" ?
                    <NaverIcon /> : '' }
                {props.children}
            </StyledButton>
        </>
    )

}

export default Button;
