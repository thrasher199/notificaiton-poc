import {useEffect, useState} from "react";
import {NotificationEndpoint} from "Frontend/generated/endpoints";

export default function NotificationView() {
    const [names, setNames] = useState<string[]>([]);

    useEffect(() => {
        NotificationEndpoint.getNotification().onNext(
            (name: string | undefined) => {
                if(typeof name === 'string'){
                    setNames(prevState => [...prevState, name]);
                }
            }
        );
    }, []);


    return (
        <>
            <section className="flex p-m gap-m items-end">
                <ul>
                    {names.map((name) => (
                        <li key={name}>{name}</li>
                    ))}
                </ul>
            </section>
        </>
    );
}